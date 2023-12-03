//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.selections

import api.type.GraphQLID
import api.type.GraphQLString
import api.type.User
import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.notNull
import kotlin.collections.List

public object CreateUserMutationSelections {
  private val __createUser: List<CompiledSelection> = listOf(
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
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "createUser",
          type = User.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("input", CompiledVariable("input")).build()
        ))
        .selections(__createUser)
        .build()
      )
}
