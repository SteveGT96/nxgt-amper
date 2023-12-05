package helpers

import org.springframework.aot.hint.RuntimeHints
import org.springframework.aot.hint.RuntimeHintsRegistrar


class CustomHints : RuntimeHintsRegistrar {
	override fun registerHints(hints: RuntimeHints, classLoader: ClassLoader?) {
		hints.resources().registerPattern("certs/*.pem")
		hints.resources().registerPattern("locales/*.properties")
	}
}