//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api

import api.adapter.RefreshTokenMutation_ResponseAdapter
import api.adapter.RefreshTokenMutation_VariablesAdapter
import api.selections.RefreshTokenMutationSelections
import api.type.MutationBuilder
import api.type.__CustomScalarAdapters
import api.type.__Schema
import api.type.buildMutation
import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.DefaultFakeResolver
import com.apollographql.apollo3.api.FakeResolver
import com.apollographql.apollo3.api.GlobalBuilder
import com.apollographql.apollo3.api.Mutation
import com.apollographql.apollo3.api.buildData
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import kotlin.String
import kotlin.Unit
import kotlinx.datetime.Instant

public data class RefreshTokenMutation(
  public val token: String,
) : Mutation<RefreshTokenMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    RefreshTokenMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = RefreshTokenMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = api.type.Mutation.type
  )
  .selections(selections = RefreshTokenMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(RefreshTokenMutation_ResponseAdapter.Data::class)
  public data class Data(
    /**
     * Refreshes an expired access token and returns a new access token.
     */
    public val refreshToken: RefreshToken,
  ) : Mutation.Data

  public data class RefreshToken(
    /**
     * The date and time at which the token was issued.
     */
    public val issuedAt: Instant,
    /**
     * The expiration date and time of the token.
     */
    public val expiration: Instant,
    /**
     * The access token, which can be used to authenticate requests to the API.
     */
    public val access: String,
    /**
     * The refresh token, which can be used to obtain a new access token after the current access
     * token has expired.
     */
    public val refresh: String,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "5cbcd2aaa43ff7db0708300d645d62978c1c4c75c37eb8e7e0030634cce98d0f"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation RefreshToken($token: String!) {
     *   refreshToken(token: $token) {
     *     issuedAt
     *     expiration
     *     access
     *     refresh
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation RefreshToken(${'$'}token: String!) { refreshToken(token: ${'$'}token) { issuedAt expiration access refresh } }"

    public const val OPERATION_NAME: String = "RefreshToken"

    public fun Data(resolver: FakeResolver = DefaultFakeResolver(__Schema.all),
        block: MutationBuilder.() -> Unit = {}): Data = buildData(
      RefreshTokenMutation_ResponseAdapter.Data,
      RefreshTokenMutationSelections.__root,
      "Mutation",
      GlobalBuilder.buildMutation(block),
      resolver,
      __CustomScalarAdapters,
    )
  }
}
