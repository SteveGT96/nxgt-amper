//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.fragment

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object RoleImpl_ResponseAdapter {
  public object Role : Adapter<api.fragment.Role> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "name", "description")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        api.fragment.Role {
      var _id: String? = null
      var _name: String? = null
      var _description: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _name = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _description = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return api.fragment.Role(
        id = _id,
        name = _name!!,
        description = _description
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: api.fragment.Role,
    ): Unit {
      writer.name("id")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("name")
      StringAdapter.toJson(writer, customScalarAdapters, value.name)

      writer.name("description")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.description)
    }
  }
}