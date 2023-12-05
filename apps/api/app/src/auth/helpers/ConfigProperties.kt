package auth.helpers

import org.springframework.boot.context.properties.ConfigurationProperties
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

@ConfigurationProperties(prefix = "rsa")
data class RsaKeyProperties(val publicKey: RSAPublicKey, val privateKey: RSAPrivateKey)

@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(val secret: String, val validity: Long, val refreshValidity: Long)