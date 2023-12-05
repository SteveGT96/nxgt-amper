package config

import helpers.CustomHints
import org.springframework.context.annotation.*

@Configuration
@EnableAspectJAutoProxy()
@ImportRuntimeHints(CustomHints::class)
class AppConfig