//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.selections

import api.type.GraphQLString
import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.notNull
import kotlin.collections.List

public object DeleteUserMutationSelections {
  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "deleteUser",
          type = GraphQLString.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("id", CompiledVariable("id")).build()
        ))
        .build()
      )
}
