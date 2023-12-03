//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.selections

import api.type.GraphQLID
import api.type.GraphQLString
import api.type.Permission
import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.notNull
import kotlin.collections.List

public object PatchPermissionMutationSelections {
  private val __patchPermission: List<CompiledSelection> = listOf(
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

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "patchPermission",
          type = Permission.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("input", CompiledVariable("input")).build()
        ))
        .selections(__patchPermission)
        .build()
      )
}
