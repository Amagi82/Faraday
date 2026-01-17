
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration

class UnitProcessor(
    val codeGenerator: CodeGenerator,
    val logger: KSPLogger,
    val platformName: String?,
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        processUnitConversions(resolver)
        processBasicUnitMath(resolver)
        return emptyList()
    }
}

fun KSClassDeclaration.primaryConstructorParameterName() =
    primaryConstructor!!.parameters.first().name!!.asString()