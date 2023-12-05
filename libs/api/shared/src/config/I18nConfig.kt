package config

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.util.*


/**
 * This class provides configuration for internationalization (i18n).
 *
 * @author Steve Tsala
 */
@Configuration
class I18nConfig {

	/**
	 * Returns a locale resolver that uses the AcceptHeaderLocaleResolver class.
	 *
	 * @return A locale resolver.
	 */
	@Bean
	fun localeResolver(): LocaleResolver {
		val localeResolver = AcceptHeaderLocaleResolver()
		localeResolver.setDefaultLocale(Locale.ENGLISH)
		return localeResolver
	}
}

fun MessageSource.translate(code: String, vararg args: Any): String {
	return getMessage(code, args, LocaleContextHolder.getLocale())
}