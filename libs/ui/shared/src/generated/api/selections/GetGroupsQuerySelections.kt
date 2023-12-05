//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.selections

import api.fragment.selections.PageInfoSelections
import api.fragment.selections.PermissionSelections
import api.fragment.selections.RoleSelections
import api.fragment.selections.UserSelections
import api.type.GraphQLID
import api.type.GraphQLString
import api.type.Group
import api.type.GroupConnection
import api.type.GroupEdge
import api.type.PageInfo
import api.type.Permission
import api.type.Role
import api.type.User
import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledFragment
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.notNull
import kotlin.collections.List

public object GetGroupsQuerySelections {
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

  private val __users: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "User",
          possibleTypes = listOf("User")
        ).selections(UserSelections.__root)
        .build()
      )

  private val __roles: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "Role",
          possibleTypes = listOf("Role")
        ).selections(RoleSelections.__root)
        .build()
      )

  private val __permissions: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "Permission",
          possibleTypes = listOf("Permission")
        ).selections(PermissionSelections.__root)
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
        ).build(),
        CompiledField.Builder(
          name = "users",
          type = User.type.notNull().list().notNull()
        ).selections(__users)
        .build(),
        CompiledField.Builder(
          name = "roles",
          type = Role.type.notNull().list().notNull()
        ).selections(__roles)
        .build(),
        CompiledField.Builder(
          name = "permissions",
          type = Permission.type.notNull().list().notNull()
        ).selections(__permissions)
        .build()
      )

  private val __edges: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "cursor",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "node",
          type = Group.type.notNull()
        ).selections(__node)
        .build()
      )

  private val __groups: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "pageInfo",
          type = PageInfo.type.notNull()
        ).selections(__pageInfo)
        .build(),
        CompiledField.Builder(
          name = "edges",
          type = GroupEdge.type.list().notNull()
        ).selections(__edges)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "groups",
          type = GroupConnection.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("after", CompiledVariable("after")).build(),
          CompiledArgument.Builder("before", CompiledVariable("before")).build(),
          CompiledArgument.Builder("first", CompiledVariable("first")).build(),
          CompiledArgument.Builder("last", CompiledVariable("last")).build()
        ))
        .selections(__groups)
        .build()
      )
}