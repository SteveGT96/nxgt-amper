//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.selections

import api.fragment.selections.PageInfoSelections
import api.type.GraphQLID
import api.type.GraphQLString
import api.type.PageInfo
import api.type.Permission
import api.type.PermissionConnection
import api.type.PermissionEdge
import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledFragment
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.notNull
import kotlin.collections.List

public object GetPermissionsQuerySelections {
  private val __pageInfo: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "PageInfo",
          possibleTypes = listOf("PageInfo")
        ).selections(PageInfoSelections.__root)
        .build()
      )

  private val __node: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type
        ).build(),
        CompiledField.Builder(
          name = "name",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "description",
          type = GraphQLString.type
        ).build()
      )

  private val __edges: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "cursor",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "node",
          type = Permission.type.notNull()
        ).selections(__node)
        .build()
      )

  private val __permissions: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "pageInfo",
          type = PageInfo.type.notNull()
        ).selections(__pageInfo)
        .build(),
        CompiledField.Builder(
          name = "edges",
          type = PermissionEdge.type.list().notNull()
        ).selections(__edges)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "permissions",
          type = PermissionConnection.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("after", CompiledVariable("after")).build(),
          CompiledArgument.Builder("before", CompiledVariable("before")).build(),
          CompiledArgument.Builder("first", CompiledVariable("first")).build(),
          CompiledArgument.Builder("last", CompiledVariable("last")).build()
        ))
        .selections(__permissions)
        .build()
      )
}
