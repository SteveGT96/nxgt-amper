//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package api.adapter

import api.GetUsersQuery
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableIntAdapter
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import kotlin.IllegalStateException
import kotlin.Unit

public object GetUsersQuery_VariablesAdapter : Adapter<GetUsersQuery> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      GetUsersQuery = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: GetUsersQuery,
  ): Unit {
    writer.name("first")
    NullableIntAdapter.toJson(writer, customScalarAdapters, value.first)
    writer.name("last")
    NullableIntAdapter.toJson(writer, customScalarAdapters, value.last)
    writer.name("before")
    NullableStringAdapter.toJson(writer, customScalarAdapters, value.before)
    writer.name("after")
    NullableStringAdapter.toJson(writer, customScalarAdapters, value.after)
  }
}
