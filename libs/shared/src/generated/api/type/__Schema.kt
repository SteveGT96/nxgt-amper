//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.type

import com.apollographql.apollo3.api.CompiledNamedType
import com.apollographql.apollo3.api.ObjectType
import kotlin.collections.List

/**
 * A __Schema object containing all the composite types and a possibleTypes helper function
 */
public object __Schema {
  public val all: List<CompiledNamedType> = listOf(
        api.type.EventType.type, api.type.Group.type, api.type.GroupConnection.type,
            api.type.GroupEdge.type, api.type.GroupEvent.type, api.type.Mutation.type,
            api.type.PageInfo.type, api.type.Permission.type, api.type.PermissionConnection.type,
            api.type.PermissionEdge.type, api.type.PermissionEvent.type, api.type.Query.type,
            api.type.Role.type, api.type.RoleConnection.type, api.type.RoleEdge.type,
            api.type.RoleEvent.type, api.type.Subscription.type, api.type.Token.type,
            api.type.User.type, api.type.UserConnection.type, api.type.UserEdge.type,
            api.type.UserEvent.type)


  public fun possibleTypes(type: CompiledNamedType): List<ObjectType> =
      com.apollographql.apollo3.api.possibleTypes(all, type)
}
