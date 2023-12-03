//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.type

import com.apollographql.apollo3.api.BuilderScope
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.ObjectBuilder
import com.apollographql.apollo3.api.ObjectType
import kotlin.Any
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public class Mutation {
  public companion object {
    public val type: ObjectType = ObjectType.Builder(name = "Mutation").build()
  }
}

public class MutationBuilder(
  customScalarAdapters: CustomScalarAdapters,
) : ObjectBuilder(customScalarAdapters) {
  public var createGroup: GroupMap by __fields

  public var updateGroup: GroupMap by __fields

  public var patchGroup: GroupMap by __fields

  public var deleteGroup: String by __fields

  public var createPermission: PermissionMap by __fields

  public var updatePermission: PermissionMap by __fields

  public var patchPermission: PermissionMap by __fields

  public var deletePermission: String by __fields

  public var createRole: RoleMap by __fields

  public var updateRole: RoleMap by __fields

  public var patchRole: RoleMap by __fields

  public var deleteRole: String by __fields

  public var createUser: UserMap by __fields

  public var updateUser: UserMap by __fields

  public var patchUser: UserMap by __fields

  public var deleteUser: String by __fields

  public fun build(): MutationMap = MutationMap(__fields)
}

public class MutationMap(
  __fields: Map<String, Any?>,
) : Map<String, Any?> by __fields

public fun BuilderScope.buildMutation(block: MutationBuilder.() -> Unit): MutationMap {
  val builder = MutationBuilder(customScalarAdapters)
  builder.__typename = "Mutation"
  builder.block()
  return builder.build()
}
