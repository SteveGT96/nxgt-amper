package helpers

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCacheFactory
import com.apollographql.apollo3.network.ws.GraphQLWsProtocol
import com.apollographql.apollo3.network.ws.WebSocketNetworkTransport
import services.AuthService

fun apolloClient(authService: AuthService): ApolloClient {
    return ApolloClient.Builder()
        .serverUrl(Api.GRAPHQL)
        .subscriptionNetworkTransport(
            WebSocketNetworkTransport.Builder()
                .protocol(GraphQLWsProtocol.Factory())
                .serverUrl(Api.SUBSCRIPTIONS)
                .build()
        )
        .addHttpInterceptor(AuthorizationInterceptor(authService))
        .normalizedCache(SqlNormalizedCacheFactory("apollo.db"))
        .fetchPolicy(FetchPolicy.NetworkFirst)
        .httpBatching()
        .build()
}
