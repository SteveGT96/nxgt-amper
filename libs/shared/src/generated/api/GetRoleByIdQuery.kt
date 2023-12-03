//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api

import api.adapter.GetRoleByIdQuery_ResponseAdapter
import api.adapter.GetRoleByIdQuery_VariablesAdapter
import api.selections.GetRoleByIdQuerySelections
import api.type.QueryBuilder
import api.type.__CustomScalarAdapters
import api.type.__Schema
import api.type.buildQuery
import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.DefaultFakeResolver
import com.apollographql.apollo3.api.FakeResolver
import com.apollographql.apollo3.api.GlobalBuilder
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.buildData
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public data class GetRoleByIdQuery(
  public val id: String,
) : Query<GetRoleByIdQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    GetRoleByIdQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = GetRoleByIdQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = api.type.Query.type
  )
  .selections(selections = GetRoleByIdQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(GetRoleByIdQuery_ResponseAdapter.Data::class)
  public data class Data(
    /**
     * Get a role by ID.
     */
    public val role: Role,
  ) : Query.Data

  public data class Role(
    /**
     * The unique identifier of the role.
     */
    public val id: String?,
    /**
     * The name of the role.
     */
    public val name: String,
    /**
     * The description of the role.
     */
    public val description: String?,
    /**
     * The permissions associated with the role.
     */
    public val permissions: List<Permission>,
  )

  public data class Permission(
    public val __typename: String,
    /**
     * Synthetic field for 'Permission'
     */
    public val permission: api.fragment.Permission,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "b91a61e976d3f95fb1aebb57fac7f6c0016236cf7333f083740bf1f7c68575a0"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query GetRoleById($id: ID!) {
     *   role(id: $id) {
     *     id
     *     name
     *     description
     *     permissions {
     *       __typename
     *       ...Permission
     *     }
     *   }
     * }
     *
     * fragment Permission on Permission {
     *   id
     *   name
     *   description
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query GetRoleById(${'$'}id: ID!) { role(id: ${'$'}id) { id name description permissions { __typename ...Permission } } }  fragment Permission on Permission { id name description }"

    public const val OPERATION_NAME: String = "GetRoleById"

    public fun Data(resolver: FakeResolver = DefaultFakeResolver(__Schema.all),
        block: QueryBuilder.() -> Unit = {}): Data = buildData(
      GetRoleByIdQuery_ResponseAdapter.Data,
      GetRoleByIdQuerySelections.__root,
      "Query",
      GlobalBuilder.buildQuery(block),
      resolver,
      __CustomScalarAdapters,
    )
  }
}