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

public class Query {
  public companion object {
    public val type: ObjectType = ObjectType.Builder(name = "Query").build()
  }
}

public class QueryBuilder(
  customScalarAdapters: CustomScalarAdapters,
) : ObjectBuilder(customScalarAdapters) {
  public var groups: GroupConnectionMap by __fields

  public var group: GroupMap by __fields

  public var permissions: PermissionConnectionMap by __fields

  public var permission: PermissionMap by __fields

  public var roles: RoleConnectionMap by __fields

  public var role: RoleMap by __fields

  public var users: UserConnectionMap by __fields

  public var user: UserMap by __fields

  public fun build(): QueryMap = QueryMap(__fields)
}

public class QueryMap(
  __fields: Map<String, Any?>,
) : Map<String, Any?> by __fields

public fun BuilderScope.buildQuery(block: QueryBuilder.() -> Unit): QueryMap {
  val builder = QueryBuilder(customScalarAdapters)
  builder.__typename = "Query"
  builder.block()
  return builder.build()
}
