//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api

import api.adapter.UpdateUserMutation_ResponseAdapter
import api.adapter.UpdateUserMutation_VariablesAdapter
import api.selections.UpdateUserMutationSelections
import api.type.MutationBuilder
import api.type.UpdateUserInput
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

public data class UpdateUserMutation(
  public val input: UpdateUserInput,
) : Mutation<UpdateUserMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    UpdateUserMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = UpdateUserMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = api.type.Mutation.type
  )
  .selections(selections = UpdateUserMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(UpdateUserMutation_ResponseAdapter.Data::class)
  public data class Data(
    /**
     * Update an existing user.
     */
    public val updateUser: UpdateUser,
  ) : Mutation.Data

  public data class UpdateUser(
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
        "ea4b0c047762a1b01c6f22e2cf7506de3151046dcf4330f9fa3898ce227d7c3b"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation UpdateUser($input: UpdateUserInput!) {
     *   updateUser(input: $input) {
     *     id
     *     username
     *     email
     *     avatar
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation UpdateUser(${'$'}input: UpdateUserInput!) { updateUser(input: ${'$'}input) { id username email avatar } }"

    public const val OPERATION_NAME: String = "UpdateUser"

    public fun Data(resolver: FakeResolver = DefaultFakeResolver(__Schema.all),
        block: MutationBuilder.() -> Unit = {}): Data = buildData(
      UpdateUserMutation_ResponseAdapter.Data,
      UpdateUserMutationSelections.__root,
      "Mutation",
      GlobalBuilder.buildMutation(block),
      resolver,
      __CustomScalarAdapters,
    )
  }
}
