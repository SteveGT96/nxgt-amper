package helpers

import com.apollographql.apollo3.api.http.HttpRequest
import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.network.http.HttpInterceptor
import com.apollographql.apollo3.network.http.HttpInterceptorChain
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import room.model.isExpired
import services.AuthService

val mutex = Mutex()

class AuthorizationInterceptor(val authService: AuthService) : HttpInterceptor {
    private val mutex = Mutex()
    override suspend fun intercept(request: HttpRequest, chain: HttpInterceptorChain): HttpResponse {
        var token = mutex.withLock {
            var t = authService.geToken()
            if(t != null && t.isExpired()) {
                authService.refreshToken()
            } else t
        }

        return if(token != null) {
            chain.proceed(request.newBuilder().addHeader("Authorization", "Bearer ${token.access}").build())
        } else chain.proceed(request)
    }
}