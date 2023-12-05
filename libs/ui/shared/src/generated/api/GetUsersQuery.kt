//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api

import api.adapter.GetUsersQuery_ResponseAdapter
import api.adapter.GetUsersQuery_VariablesAdapter
import api.selections.GetUsersQuerySelections
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
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public data class GetUsersQuery(
  public val first: Int?,
  public val last: Int?,
  public val before: String?,
  public val after: String?,
) : Query<GetUsersQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    GetUsersQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = GetUsersQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = api.type.Query.type
  )
  .selections(selections = GetUsersQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(GetUsersQuery_ResponseAdapter.Data::class)
  public data class Data(
    /**
     * Get all users.
     */
    public val users: Users,
  ) : Query.Data

  public data class Users(
    public val pageInfo: PageInfo,
    public val edges: List<Edge?>,
  ) {
    public fun edgesFilterNotNull(): List<Edge> = edges.filterNotNull()
  }

  public data class PageInfo(
    public val __typename: String,
    /**
     * Synthetic field for 'PageInfo'
     */
    public val pageInfo: api.fragment.PageInfo,
  )

  public data class Edge(
    public val cursor: String,
    public val node: Node,
  )

  public data class Node(
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
    /**
     * The groups associated with the user.
     */
    public val groups: List<Group>,
    /**
     * The roles associated with the user.
     */
    public val roles: List<Role>,
    /**
     * The permissions associated with the user.
     */
    public val permissions: List<Permission>,
  )

  public data class Group(
    public val __typename: String,
    /**
     * Synthetic field for 'Group'
     */
    public val group: api.fragment.Group,
  )

  public data class Role(
    public val __typename: String,
    /**
     * Synthetic field for 'Role'
     */
    public val role: api.fragment.Role,
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
        "c389c58f4e15213caba9e1b489f844dc71a265eb13a8808582e6d076c0066758"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query GetUsers($first: Int, $last: Int, $before: String, $after: String) {
     *   users(first: $first, last: $last, before: $before, after: $after) {
     *     pageInfo {
     *       __typename
     *       ...PageInfo
     *     }
     *     edges {
     *       cursor
     *       node {
     *         id
     *         username
     *         email
     *         avatar
     *         groups {
     *           __typename
     *           ...Group
     *         }
     *         roles {
     *           __typename
     *           ...Role
     *         }
     *         permissions {
     *           __typename
     *           ...Permission
     *         }
     *       }
     *     }
     *   }
     * }
     *
     * fragment PageInfo on PageInfo {
     *   startCursor
     *   endCursor
     *   hasPreviousPage
     *   hasNextPage
     * }
     *
     * fragment Group on Group {
     *   id
     *   name
     *   description
     * }
     *
     * fragment Role on Role {
     *   id
     *   name
     *   description
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
          "query GetUsers(${'$'}first: Int, ${'$'}last: Int, ${'$'}before: String, ${'$'}after: String) { users(first: ${'$'}first, last: ${'$'}last, before: ${'$'}before, after: ${'$'}after) { pageInfo { __typename ...PageInfo } edges { cursor node { id username email avatar groups { __typename ...Group } roles { __typename ...Role } permissions { __typename ...Permission } } } } }  fragment PageInfo on PageInfo { startCursor endCursor hasPreviousPage hasNextPage }  fragment Group on Group { id name description }  fragment Role on Role { id name description }  fragment Permission on Permission { id name description }"

    public const val OPERATION_NAME: String = "GetUsers"

    public fun Data(resolver: FakeResolver = DefaultFakeResolver(__Schema.all),
        block: QueryBuilder.() -> Unit = {}): Data = buildData(
      GetUsersQuery_ResponseAdapter.Data,
      GetUsersQuerySelections.__root,
      "Query",
      GlobalBuilder.buildQuery(block),
      resolver,
      __CustomScalarAdapters,
    )
  }
}