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

public class GroupEdge {
  public companion object {
    public val type: ObjectType = ObjectType.Builder(name = "GroupEdge").build()
  }
}

public class GroupEdgeBuilder(
  customScalarAdapters: CustomScalarAdapters,
) : ObjectBuilder(customScalarAdapters) {
  public var cursor: String by __fields

  public var node: GroupMap by __fields

  public fun build(): GroupEdgeMap = GroupEdgeMap(__fields)
}

public class GroupEdgeMap(
  __fields: Map<String, Any?>,
) : Map<String, Any?> by __fields

public fun BuilderScope.buildGroupEdge(block: GroupEdgeBuilder.() -> Unit): GroupEdgeMap {
  val builder = GroupEdgeBuilder(customScalarAdapters)
  builder.__typename = "GroupEdge"
  builder.block()
  return builder.build()
}
