//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.adapter

import api.UpdateUserMutation
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

public object UpdateUserMutation_ResponseAdapter {
  public object Data : Adapter<UpdateUserMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("updateUser")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UpdateUserMutation.Data {
      var _updateUser: UpdateUserMutation.UpdateUser? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _updateUser = UpdateUser.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UpdateUserMutation.Data(
        updateUser = _updateUser!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UpdateUserMutation.Data,
    ): Unit {
      writer.name("updateUser")
      UpdateUser.obj().toJson(writer, customScalarAdapters, value.updateUser)
    }
  }

  public object UpdateUser : Adapter<UpdateUserMutation.UpdateUser> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "username", "email", "avatar")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UpdateUserMutation.UpdateUser {
      var _id: String? = null
      var _username: String? = null
      var _email: String? = null
      var _avatar: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _username = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _email = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _avatar = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UpdateUserMutation.UpdateUser(
        id = _id!!,
        username = _username!!,
        email = _email!!,
        avatar = _avatar
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UpdateUserMutation.UpdateUser,
    ): Unit {
      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("username")
      StringAdapter.toJson(writer, customScalarAdapters, value.username)

      writer.name("email")
      StringAdapter.toJson(writer, customScalarAdapters, value.email)

      writer.name("avatar")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.avatar)
    }
  }
}
