package services

import api.*
import api.type.LoginInput
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import helpers.Api
import room.model.Token
import room.repository.TokenRepository

class AuthService(private val repository: TokenRepository) {
    val client = ApolloClient.Builder()
        .serverUrl(Api.GRAPHQL)
        .fetchPolicy(FetchPolicy.NetworkOnly)
        .build()

    suspend fun geToken() = repository.findAll().firstOrNull()

    suspend fun refreshToken(): Token? {
        val token = repository.findAll().firstOrNull()
        if (token == null) {
            return null
        }
        repository.deleteAll()
        val result = client.mutation(RefreshTokenMutation(token.refresh)).execute()
        val data = result.data?.refreshToken
        return if(data != null) {
            val entity = Token(token.username, data.access, data.refresh, data.expiration.toString())
            repository.insert(entity)
            entity
        } else null
    }

    suspend fun saveToken(token: Token) {
        repository.deleteAll()
        repository.insert(token)
    }

    suspend fun login(credential: LoginInput, onError: (String) -> Unit = {}) {
        repository.deleteAll()
        val result = client.mutation(LoginMutation(credential)).execute()
        var errorMessage = result.errors?.firstOrNull()?.message
        if(errorMessage != null){
            onError(errorMessage)
        }
        val token = result.data?.login
        if(token != null) {
            repository.deleteAll()
            val entity = Token(credential.username, token.access, token.refresh, token.expiration.toString())
            repository.insert(entity)
        }
    }

    suspend fun logout(with: ApolloClient) {
        with.mutation(LogoutMutation())
        repository.deleteAll()
    }
}