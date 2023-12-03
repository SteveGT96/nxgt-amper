//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.selections

import api.type.EventType
import api.type.GraphQLID
import api.type.GraphQLString
import api.type.User
import api.type.UserEvent
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import kotlin.collections.List

public object WatchUserChangeSubscriptionSelections {
  private val __data: List<CompiledSelection> = listOf(
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

  private val __onUserChange: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "type",
          type = EventType.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "data",
          type = User.type.notNull()
        ).selections(__data)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "onUserChange",
          type = UserEvent.type.notNull()
        ).selections(__onUserChange)
        .build()
      )
}
