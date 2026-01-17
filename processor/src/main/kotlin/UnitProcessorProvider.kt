import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class UnitProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor = UnitProcessor(
        codeGenerator = environment.codeGenerator,
        logger = environment.logger,
        platformName = environment.platforms.firstOrNull()?.platformName
    )
}