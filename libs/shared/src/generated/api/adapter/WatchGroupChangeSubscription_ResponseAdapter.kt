//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.adapter

import api.WatchGroupChangeSubscription
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

public object WatchGroupChangeSubscription_ResponseAdapter {
  public object Data : Adapter<WatchGroupChangeSubscription.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("onGroupChange")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        WatchGroupChangeSubscription.Data {
      var _onGroupChange: WatchGroupChangeSubscription.OnGroupChange? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _onGroupChange = OnGroupChange.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return WatchGroupChangeSubscription.Data(
        onGroupChange = _onGroupChange!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: WatchGroupChangeSubscription.Data,
    ): Unit {
      writer.name("onGroupChange")
      OnGroupChange.obj().toJson(writer, customScalarAdapters, value.onGroupChange)
    }
  }

  public object OnGroupChange : Adapter<WatchGroupChangeSubscription.OnGroupChange> {
    public val RESPONSE_NAMES: List<String> = listOf("type", "data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        WatchGroupChangeSubscription.OnGroupChange {
      var _type: EventType? = null
      var _data: WatchGroupChangeSubscription.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _type = EventType_ResponseAdapter.fromJson(reader, customScalarAdapters)
          1 -> _data = Data1.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return WatchGroupChangeSubscription.OnGroupChange(
        type = _type!!,
        `data` = _data!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: WatchGroupChangeSubscription.OnGroupChange,
    ): Unit {
      writer.name("type")
      EventType_ResponseAdapter.toJson(writer, customScalarAdapters, value.type)

      writer.name("data")
      Data1.obj().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<WatchGroupChangeSubscription.Data1> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "name", "description")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        WatchGroupChangeSubscription.Data1 {
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

      return WatchGroupChangeSubscription.Data1(
        id = _id,
        name = _name!!,
        description = _description
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: WatchGroupChangeSubscription.Data1,
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
