//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.fragment.selections

import api.type.DateTime
import api.type.GraphQLString
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import kotlin.collections.List

public object TokenSelections {
  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "issuedAt",
          type = DateTime.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "expiration",
          type = DateTime.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "access",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "refresh",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "username",
          type = GraphQLString.type.notNull()
        ).build()
      )
}