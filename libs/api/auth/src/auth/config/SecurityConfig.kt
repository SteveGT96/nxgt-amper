package auth.config

import com.nimbusds.jose.jwk.*
import com.nimbusds.jose.jwk.source.ImmutableJWKSet
import com.nimbusds.jose.jwk.source.JWKSource
import com.nimbusds.jose.proc.SecurityContext
import auth.helpers.*
import auth.services.UserService
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.jwt.*
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@ComponentScan(basePackages = ["shared", "auth"])
@EnableConfigurationProperties(RsaKeyProperties::class, JwtProperties::class)
class SecurityConfig {

	@Bean
	fun passwordEncoder() = BCryptPasswordEncoder()

	@Bean
	fun securityFilterChain(http: HttpSecurity, jwtTokenFilter: JwtTokenFilter): SecurityFilterChain {
		http {
			csrf { }
			authorizeRequests {
				listOf("/sandbox", "/graphql", "/graphiql", "/favicon.ico").forEach {
					authorize(it, permitAll)
				}
				authorize(anyRequest, authenticated)
			}
			httpBasic { disable() }
			formLogin { disable() }
			cors { disable() }
			csrf { disable() }
		}

		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)

		return http.build()
	}

	@Bean
	fun authenticationManager(
		http: HttpSecurity, passwordEncoder: BCryptPasswordEncoder, userDetailsService: UserService
	): AuthenticationManager {
		val authenticationManager = http.getSharedObject(AuthenticationManagerBuilder::class.java)
		authenticationManager.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder)
		return authenticationManager.build()
	}

	@Bean
	fun jwtEncoder(rsa: RsaKeyProperties): JwtEncoder {
		val jwk: JWK = RSAKey.Builder(rsa.publicKey).privateKey(rsa.privateKey).build()
		val jwks: JWKSource<SecurityContext> = ImmutableJWKSet(JWKSet(jwk))
		return NimbusJwtEncoder(jwks)
	}

	@Bean
	fun jwtDecoder(rsa: RsaKeyProperties): JwtDecoder {
		return NimbusJwtDecoder.withPublicKey(rsa.publicKey).build()
	}
}