//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api

import api.adapter.PatchUserMutation_ResponseAdapter
import api.adapter.PatchUserMutation_VariablesAdapter
import api.selections.PatchUserMutationSelections
import api.type.MutationBuilder
import api.type.PatchUserInput
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

public data class PatchUserMutation(
  public val input: PatchUserInput,
) : Mutation<PatchUserMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    PatchUserMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = PatchUserMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = api.type.Mutation.type
  )
  .selections(selections = PatchUserMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(PatchUserMutation_ResponseAdapter.Data::class)
  public data class Data(
    /**
     * Patch an existing user.
     */
    public val patchUser: PatchUser,
  ) : Mutation.Data

  public data class PatchUser(
    /**
     * The unique identifier of the user.
     */
    public val id: String,
    /**
     * The user's username.
     */
    public val username: String,
    /**
     * The user's email address.
     */
    public val email: String,
    /**
     * The user's avatar image.
     */
    public val avatar: String?,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "dbf6973bc3405ce5960af300a03901cd8c0a24fa5e03827711cd5e00e865c1a0"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation PatchUser($input: PatchUserInput!) {
     *   patchUser(input: $input) {
     *     id
     *     username
     *     email
     *     avatar
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation PatchUser(${'$'}input: PatchUserInput!) { patchUser(input: ${'$'}input) { id username email avatar } }"

    public const val OPERATION_NAME: String = "PatchUser"

    public fun Data(resolver: FakeResolver = DefaultFakeResolver(__Schema.all),
        block: MutationBuilder.() -> Unit = {}): Data = buildData(
      PatchUserMutation_ResponseAdapter.Data,
      PatchUserMutationSelections.__root,
      "Mutation",
      GlobalBuilder.buildMutation(block),
      resolver,
      __CustomScalarAdapters,
    )
  }
}
