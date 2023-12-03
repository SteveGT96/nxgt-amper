//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.adapter

import api.DeleteGroupMutation
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object DeleteGroupMutation_ResponseAdapter {
  public object Data : Adapter<DeleteGroupMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("deleteGroup")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        DeleteGroupMutation.Data {
      var _deleteGroup: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _deleteGroup = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return DeleteGroupMutation.Data(
        deleteGroup = _deleteGroup!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: DeleteGroupMutation.Data,
    ): Unit {
      writer.name("deleteGroup")
      StringAdapter.toJson(writer, customScalarAdapters, value.deleteGroup)
    }
  }
}
