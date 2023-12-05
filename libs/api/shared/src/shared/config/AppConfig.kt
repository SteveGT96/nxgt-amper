package shared.config

import shared.helpers.CustomHints
import org.springframework.context.annotation.*

@Configuration
@EnableAspectJAutoProxy()
@ImportRuntimeHints(CustomHints::class)
class AppConfig