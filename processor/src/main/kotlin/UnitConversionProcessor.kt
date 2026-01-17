import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSAnnotation
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSType
import com.google.devtools.ksp.symbol.KSTypeAlias
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ksp.toTypeName
import com.squareup.kotlinpoet.ksp.writeTo

fun UnitProcessor.processUnitConversions(resolver: Resolver) {
    resolver.getSymbolsWithAnnotation("faraday.Conversion")
        .filterIsInstance<KSClassDeclaration>()
        .forEach { identity ->
            val annotations = identity.annotations.filter { it.shortName.asString() == "Conversion" }
            logger.warn("Faraday KSP: Found ${identity.simpleName.asString()} with ${annotations.toList().size} annotations.")
            annotations.forEach { annotation ->
                processUnitConversionAnnotation(identity, annotation)
            }
        }
}

private fun UnitProcessor.processUnitConversionAnnotation(identity: KSClassDeclaration, annotation: KSAnnotation) {
    val f1 = annotation.arguments[0].value as KSType
    val f2 = annotation.arguments[1].value as KSType
    val result = annotation.arguments[2].value as KSType

    FileSpec.builder(
        packageName = identity.packageName.asString(),
        fileName = "Convert${f1.nameAsString()}Times${f2.nameAsString()}To${result.nameAsString()}"
    ).apply {
        // Generate the 4-way relationship
        addFunction(unitConversion(receiver = f1, param = f2, returns = result, op = Operation.Times))
        if (f1 != f2) {
            addFunction(unitConversion(receiver = f2, param = f1, returns = result, op = Operation.Times))
            addFunction(unitConversion(receiver = result, param = f1, returns = f2, op = Operation.Div))
        }
        addFunction(unitConversion(receiver = result, param = f2, returns = f1, op = Operation.Div))
    }.build().writeTo(codeGenerator, Dependencies(aggregating = true))
}

private fun unitConversion(
    receiver: KSType,
    param: KSType,
    returns: KSType,
    op: Operation,
): FunSpec {
    val receiverName = receiver.nameAsString()
    val paramName = param.nameAsString()

    val receiverParamName = receiver.primaryConstructorParameterName()
    val paramParamName = param.primaryConstructorParameterName()
    val returnsParamName = returns.primaryConstructorParameterName()

    return FunSpec.build(op.operator) {
        addModifiers(KModifier.OPERATOR)
        receiver(receiver.toTypeName())
        addParameter(paramName.replaceFirstChar { it.lowercase() }, param.toTypeName())
        returns(returns.toTypeName())
        addAnnotation(
            AnnotationSpec.builder(JvmName::class)
                .addMember("%S", "${receiverName.replaceFirstChar { it.lowercase() }}${op.name}$paramName")
                .build()
        )
        addStatement(
            "return %T($returnsParamName = $receiverParamName ${op.symbol} ${paramName.replaceFirstChar { it.lowercase() }}.$paramParamName)",
            returns.toTypeName()
        )
    }
}

private fun KSType.primaryConstructorParameterName() = when (val declaration = declaration) {
    is KSClassDeclaration -> declaration.primaryConstructorParameterName()
    is KSTypeAlias -> (declaration.type.resolve().declaration as KSClassDeclaration).primaryConstructorParameterName()
    else -> error("Unsupported declaration type $declaration")
}

private fun KSType.nameAsString(): String = declaration.simpleName.asString()

private fun FunSpec.Companion.build(name: String, block: FunSpec.Builder.() -> Unit): FunSpec =
    FunSpec.builder(name).apply(block).build()
