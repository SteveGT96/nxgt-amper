//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api

import api.adapter.DeleteGroupMutation_ResponseAdapter
import api.adapter.DeleteGroupMutation_VariablesAdapter
import api.selections.DeleteGroupMutationSelections
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

public data class DeleteGroupMutation(
  public val id: String,
) : Mutation<DeleteGroupMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    DeleteGroupMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = DeleteGroupMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = api.type.Mutation.type
  )
  .selections(selections = DeleteGroupMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(DeleteGroupMutation_ResponseAdapter.Data::class)
  public data class Data(
    /**
     * Delete an existing group.
     */
    public val deleteGroup: String,
  ) : Mutation.Data

  public companion object {
    public const val OPERATION_ID: String =
        "fce411f0b11f5883b4867eca7e97db733e77f85ddad9d6db2b1aa8fd4a44993c"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation DeleteGroup($id: ID!) {
     *   deleteGroup(id: $id)
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() = "mutation DeleteGroup(${'$'}id: ID!) { deleteGroup(id: ${'$'}id) }"

    public const val OPERATION_NAME: String = "DeleteGroup"

    public fun Data(resolver: FakeResolver = DefaultFakeResolver(__Schema.all),
        block: MutationBuilder.() -> Unit = {}): Data = buildData(
      DeleteGroupMutation_ResponseAdapter.Data,
      DeleteGroupMutationSelections.__root,
      "Mutation",
      GlobalBuilder.buildMutation(block),
      resolver,
      __CustomScalarAdapters,
    )
  }
}
