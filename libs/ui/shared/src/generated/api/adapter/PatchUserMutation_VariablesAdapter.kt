//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.adapter

import api.PatchUserMutation
import api.type.adapter.PatchUserInput_InputAdapter
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import kotlin.IllegalStateException
import kotlin.Unit

public object PatchUserMutation_VariablesAdapter : Adapter<PatchUserMutation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      PatchUserMutation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: PatchUserMutation,
  ): Unit {
    writer.name("input")
    PatchUserInput_InputAdapter.obj().toJson(writer, customScalarAdapters, value.input)
  }
}
