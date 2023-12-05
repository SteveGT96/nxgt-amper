//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.fragment.selections

import api.type.GraphQLBoolean
import api.type.GraphQLString
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import kotlin.collections.List

public object PageInfoSelections {
  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "startCursor",
          type = GraphQLString.type
        ).build(),
        CompiledField.Builder(
          name = "endCursor",
          type = GraphQLString.type
        ).build(),
        CompiledField.Builder(
          name = "hasPreviousPage",
          type = GraphQLBoolean.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "hasNextPage",
          type = GraphQLBoolean.type.notNull()
        ).build()
      )
}