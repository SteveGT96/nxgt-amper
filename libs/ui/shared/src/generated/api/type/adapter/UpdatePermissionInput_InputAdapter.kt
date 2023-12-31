//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.type.adapter

import api.type.UpdatePermissionInput
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.present
import kotlin.IllegalStateException
import kotlin.Unit

public object UpdatePermissionInput_InputAdapter : Adapter<UpdatePermissionInput> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      UpdatePermissionInput = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: UpdatePermissionInput,
  ): Unit {
    if (value.id is Optional.Present) {
      writer.name("id")
      NullableStringAdapter.present().toJson(writer, customScalarAdapters, value.id)
    }
    writer.name("name")
    StringAdapter.toJson(writer, customScalarAdapters, value.name)
    if (value.description is Optional.Present) {
      writer.name("description")
      NullableStringAdapter.present().toJson(writer, customScalarAdapters, value.description)
    }
  }
}
