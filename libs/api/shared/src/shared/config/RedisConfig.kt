package shared.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate


@Configuration
class RedisConfig {
	@Bean
	fun redisConnectionFactory(): RedisConnectionFactory {
		//val config = RedisStandaloneConfiguration("server", 6379)
		return JedisConnectionFactory()
	}

	@Bean
	fun stringRedisTemplate(connectionFactory: RedisConnectionFactory): StringRedisTemplate {
		val template = StringRedisTemplate()
		template.connectionFactory = connectionFactory
		return template
	}

	@Bean
	fun redisTemplate(connectionFactory: RedisConnectionFactory): RedisTemplate<String, Any> {
		val template = RedisTemplate<String, Any>()
		template.connectionFactory = connectionFactory
		return template
	}
}