//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.type.adapter

import api.type.UpdateUserInput
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.present
import kotlin.IllegalStateException
import kotlin.Unit

public object UpdateUserInput_InputAdapter : Adapter<UpdateUserInput> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      UpdateUserInput = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: UpdateUserInput,
  ): Unit {
    writer.name("id")
    StringAdapter.toJson(writer, customScalarAdapters, value.id)
    writer.name("username")
    StringAdapter.toJson(writer, customScalarAdapters, value.username)
    writer.name("password")
    StringAdapter.toJson(writer, customScalarAdapters, value.password)
    writer.name("email")
    StringAdapter.toJson(writer, customScalarAdapters, value.email)
    if (value.avatar is Optional.Present) {
      writer.name("avatar")
      NullableStringAdapter.present().toJson(writer, customScalarAdapters, value.avatar)
    }
    if (value.groups is Optional.Present) {
      writer.name("groups")
      StringAdapter.list().nullable().present().toJson(writer, customScalarAdapters, value.groups)
    }
    if (value.roles is Optional.Present) {
      writer.name("roles")
      StringAdapter.list().nullable().present().toJson(writer, customScalarAdapters, value.roles)
    }
    if (value.permissions is Optional.Present) {
      writer.name("permissions")
      StringAdapter.list().nullable().present().toJson(writer, customScalarAdapters,
          value.permissions)
    }
  }
}
