//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.selections

import api.fragment.selections.GroupSelections
import api.fragment.selections.PermissionSelections
import api.fragment.selections.RoleSelections
import api.type.GraphQLID
import api.type.GraphQLString
import api.type.Group
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

public object GetUserByIdQuerySelections {
  private val __groups: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "Group",
          possibleTypes = listOf("Group")
        ).selections(GroupSelections.__root)
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

  private val __user: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "username",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "email",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "avatar",
          type = GraphQLString.type
        ).build(),
        CompiledField.Builder(
          name = "groups",
          type = Group.type.notNull().list().notNull()
        ).selections(__groups)
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

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "user",
          type = User.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("id", CompiledVariable("id")).build()
        ))
        .selections(__user)
        .build()
      )
}