//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.adapter

import api.CreateRoleMutation
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object CreateRoleMutation_ResponseAdapter {
  public object Data : Adapter<CreateRoleMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("createRole")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        CreateRoleMutation.Data {
      var _createRole: CreateRoleMutation.CreateRole? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _createRole = CreateRole.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return CreateRoleMutation.Data(
        createRole = _createRole!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: CreateRoleMutation.Data,
    ): Unit {
      writer.name("createRole")
      CreateRole.obj().toJson(writer, customScalarAdapters, value.createRole)
    }
  }

  public object CreateRole : Adapter<CreateRoleMutation.CreateRole> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "name", "description")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        CreateRoleMutation.CreateRole {
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

      return CreateRoleMutation.CreateRole(
        id = _id,
        name = _name!!,
        description = _description
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: CreateRoleMutation.CreateRole,
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
