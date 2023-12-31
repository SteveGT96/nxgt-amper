//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.adapter

import api.PatchUserMutation
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

public object PatchUserMutation_ResponseAdapter {
  public object Data : Adapter<PatchUserMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("patchUser")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        PatchUserMutation.Data {
      var _patchUser: PatchUserMutation.PatchUser? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _patchUser = PatchUser.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return PatchUserMutation.Data(
        patchUser = _patchUser!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: PatchUserMutation.Data,
    ): Unit {
      writer.name("patchUser")
      PatchUser.obj().toJson(writer, customScalarAdapters, value.patchUser)
    }
  }

  public object PatchUser : Adapter<PatchUserMutation.PatchUser> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "username", "email", "avatar")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        PatchUserMutation.PatchUser {
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

      return PatchUserMutation.PatchUser(
        id = _id!!,
        username = _username!!,
        email = _email!!,
        avatar = _avatar
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: PatchUserMutation.PatchUser,
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
