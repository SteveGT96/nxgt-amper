package helpers

object Api {
    const val HOST = "192.168.8.200:8080"
    const val GRAPHQL = "http://$HOST/graphql"
    const val SUBSCRIPTIONS = "ws://$HOST/graphql"
    const val REST = "http://$HOST/api"
}