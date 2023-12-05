//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.adapter

import api.UpdateRoleMutation
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

public object UpdateRoleMutation_ResponseAdapter {
  public object Data : Adapter<UpdateRoleMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("updateRole")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UpdateRoleMutation.Data {
      var _updateRole: UpdateRoleMutation.UpdateRole? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _updateRole = UpdateRole.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UpdateRoleMutation.Data(
        updateRole = _updateRole!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UpdateRoleMutation.Data,
    ): Unit {
      writer.name("updateRole")
      UpdateRole.obj().toJson(writer, customScalarAdapters, value.updateRole)
    }
  }

  public object UpdateRole : Adapter<UpdateRoleMutation.UpdateRole> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "name", "description")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UpdateRoleMutation.UpdateRole {
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

      return UpdateRoleMutation.UpdateRole(
        id = _id,
        name = _name!!,
        description = _description
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UpdateRoleMutation.UpdateRole,
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