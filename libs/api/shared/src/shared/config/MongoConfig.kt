package shared.config

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import java.util.*


@Configuration
@EnableMongoAuditing
class MongoConfig : AbstractMongoClientConfiguration() {
	@Value("\${spring.data.mongodb.database}")
	var database: String = "api_db"

	@Value("\${spring.data.mongodb.uri}")
	var uri: String = "http://localhost:27017/boot"
	override fun getDatabaseName(): String = database

	override fun mongoClient(): MongoClient {
		return MongoClients.create(uri)
	}

	override fun autoIndexCreation(): Boolean = true

	@Bean
	fun auditorProvider(): AuditorAware<String> {
		return SpringSecurityAuditorAware()
	}


	internal class SpringSecurityAuditorAware : AuditorAware<String> {
		override fun getCurrentAuditor(): Optional<String> {
			return Optional.ofNullable(
				(SecurityContextHolder.getContext().authentication?.principal as? UserDetails)?.username ?: ""
			)
		}
	}


}