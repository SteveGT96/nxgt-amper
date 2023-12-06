package auth.helpers

import org.springframework.data.redis.core.StringRedisTemplate
import java.time.Duration

fun StringRedisTemplate.loadValue(key: String) = boundValueOps(key).get()
fun StringRedisTemplate.removeKeys(vararg keys: String) = keys.map { expire(it, Duration.ofMillis(1)) }