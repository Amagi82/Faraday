package faraday

import com.squareup.kotlinpoet.*
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import kotlin.reflect.KClass

class Processor: AbstractProcessor() {
    override fun process(set: Set<TypeElement>, env: RoundEnvironment): Boolean {
//        val buildDir = processingEnv.options["analytics.buildDir"]!!
//        val docDir = File(File(buildDir, "outputs"), "docs").apply { mkdirs() }
//        val outFile = File(docDir, "analytics.json").also { if (it.exists()) return true }

        val units = mutableListOf<UnitData>()
        val conversions = mutableListOf<UnitConversion>()

        env.getElementsAnnotatedWith(FaradayUnit::class.java).forEach { element ->
            val unit = element.getAnnotation<FaradayUnit>()

            units.add(UnitData(
                className = element.simpleName.toString(),
                siUnitName = unit.siUnit,
                units = unit.metricUnits.map { UnitFactorData(it.name.toLowerCase(), it.factor) } + unit.additionalUnits.map{ UnitFactorData(it.unit, it.factor)}))

            unit.conversions.forEach {
                conversions.add(UnitConversion(result = element.asType()::class, numerator = it.numerator, denominator = it.denominator))
            }
        }

        conversions.forEach { conversion ->
            units.find { it.className == conversion.numerator.simpleName }?.let { unit ->

            }
            units.find { it.className == conversion.denominator.simpleName }?.let{ unit ->

            }
            units.find { it.className == conversion.result.simpleName }?.let{ unit ->

            }
        }

        units.forEach { unit ->
            val unitClass = ClassName("faraday", unit.className)
            val file = FileSpec.builder("faraday", unit.className).apply {
                addType(TypeSpec.classBuilder(unit.className).apply {
                    addModifiers(KModifier.INLINE)
                    primaryConstructor(FunSpec.constructorBuilder().addParameter(unit.siUnitName, Double::class).build())
                    unit.units.forEach {
                        addProperty(PropertySpec.builder(it.unitName, Double::class)
                            .getter(FunSpec.getterBuilder().addStatement("return %S", "${unit.siUnitName} / ${it.factor}").build())
                            .build())
                    }


                }.build())
            }.build()

            file.writeTo(System.out)

        }


        return true
    }

    private inline fun <reified A : Annotation> Element.getAnnotation() = getAnnotation(A::class.java)

    data class UnitData(val className: String, val siUnitName: String, val units: List<UnitFactorData>, val conversions: MutableSet<UnitConversionData> = mutableSetOf())

    data class UnitFactorData(val unitName: String, val factor: Double)

    data class UnitConversion(val result: KClass<*>, val numerator: KClass<*>, val denominator: KClass<*>)

    sealed class UnitConversionData{
        data class Times(val other: KClass<*>, val result: KClass<*>)
        data class Div(val by: KClass<*>, val result: KClass<*>)
    }
}
