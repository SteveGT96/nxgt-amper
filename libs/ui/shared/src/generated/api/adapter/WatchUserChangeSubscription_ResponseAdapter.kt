//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.adapter

import api.WatchUserChangeSubscription
import api.type.EventType
import api.type.adapter.EventType_ResponseAdapter
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

public object WatchUserChangeSubscription_ResponseAdapter {
  public object Data : Adapter<WatchUserChangeSubscription.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("onUserChange")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        WatchUserChangeSubscription.Data {
      var _onUserChange: WatchUserChangeSubscription.OnUserChange? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _onUserChange = OnUserChange.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return WatchUserChangeSubscription.Data(
        onUserChange = _onUserChange!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: WatchUserChangeSubscription.Data,
    ): Unit {
      writer.name("onUserChange")
      OnUserChange.obj().toJson(writer, customScalarAdapters, value.onUserChange)
    }
  }

  public object OnUserChange : Adapter<WatchUserChangeSubscription.OnUserChange> {
    public val RESPONSE_NAMES: List<String> = listOf("type", "data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        WatchUserChangeSubscription.OnUserChange {
      var _type: EventType? = null
      var _data: WatchUserChangeSubscription.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _type = EventType_ResponseAdapter.fromJson(reader, customScalarAdapters)
          1 -> _data = Data1.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return WatchUserChangeSubscription.OnUserChange(
        type = _type!!,
        `data` = _data!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: WatchUserChangeSubscription.OnUserChange,
    ): Unit {
      writer.name("type")
      EventType_ResponseAdapter.toJson(writer, customScalarAdapters, value.type)

      writer.name("data")
      Data1.obj().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<WatchUserChangeSubscription.Data1> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "username", "email", "avatar")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        WatchUserChangeSubscription.Data1 {
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

      return WatchUserChangeSubscription.Data1(
        id = _id!!,
        username = _username!!,
        email = _email!!,
        avatar = _avatar
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: WatchUserChangeSubscription.Data1,
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
