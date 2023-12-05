//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.fragment

import api.fragment.selections.PermissionSelections
import api.type.PermissionMap
import api.type.__CustomScalarAdapters
import api.type.__Schema
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.BuilderScope
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.DefaultFakeResolver
import com.apollographql.apollo3.api.FakeResolver
import com.apollographql.apollo3.api.Fragment
import com.apollographql.apollo3.api.buildFragmentData
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Unit

public class PermissionImpl() : Fragment<Permission> {
  public override fun equals(other: Any?): Boolean = other != null && other::class == this::class

  public override fun hashCode(): Int = this::class.hashCode()

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    // This fragment doesn't have any variable
  }

  public override fun adapter(): Adapter<Permission> =
      PermissionImpl_ResponseAdapter.Permission.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = api.type.Permission.type
  )
  .selections(selections = PermissionSelections.__root)
  .build()

  public companion object {
    public fun Data(resolver: FakeResolver = DefaultFakeResolver(__Schema.all),
        block: (BuilderScope.() -> PermissionMap)? = null): Permission = buildFragmentData(
      PermissionImpl_ResponseAdapter.Permission,
      PermissionSelections.__root,
      "Permission",
      block,
      resolver,
      api.type.Permission.type,
      __CustomScalarAdapters,
    )
  }
}