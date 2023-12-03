//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api

import api.adapter.PatchGroupMutation_ResponseAdapter
import api.adapter.PatchGroupMutation_VariablesAdapter
import api.selections.PatchGroupMutationSelections
import api.type.MutationBuilder
import api.type.PatchGroupInput
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

public data class PatchGroupMutation(
  public val input: PatchGroupInput,
) : Mutation<PatchGroupMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    PatchGroupMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = PatchGroupMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = api.type.Mutation.type
  )
  .selections(selections = PatchGroupMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(PatchGroupMutation_ResponseAdapter.Data::class)
  public data class Data(
    /**
     * Patch an existing group.
     */
    public val patchGroup: PatchGroup,
  ) : Mutation.Data

  public data class PatchGroup(
    /**
     * The unique identifier of the group.
     */
    public val id: String?,
    /**
     * The name of the group.
     */
    public val name: String,
    /**
     * The description of the group.
     */
    public val description: String?,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "a05c09288d015297a1e3001ce9a682770b3d5db93b29d1174904d749ec88dc27"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation PatchGroup($input: PatchGroupInput!) {
     *   patchGroup(input: $input) {
     *     id
     *     name
     *     description
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation PatchGroup(${'$'}input: PatchGroupInput!) { patchGroup(input: ${'$'}input) { id name description } }"

    public const val OPERATION_NAME: String = "PatchGroup"

    public fun Data(resolver: FakeResolver = DefaultFakeResolver(__Schema.all),
        block: MutationBuilder.() -> Unit = {}): Data = buildData(
      PatchGroupMutation_ResponseAdapter.Data,
      PatchGroupMutationSelections.__root,
      "Mutation",
      GlobalBuilder.buildMutation(block),
      resolver,
      __CustomScalarAdapters,
    )
  }
}
