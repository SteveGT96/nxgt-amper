//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.adapter

import api.PatchGroupMutation
import api.type.adapter.PatchGroupInput_InputAdapter
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import kotlin.IllegalStateException
import kotlin.Unit

public object PatchGroupMutation_VariablesAdapter : Adapter<PatchGroupMutation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      PatchGroupMutation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: PatchGroupMutation,
  ): Unit {
    writer.name("input")
    PatchGroupInput_InputAdapter.obj().toJson(writer, customScalarAdapters, value.input)
  }
}
