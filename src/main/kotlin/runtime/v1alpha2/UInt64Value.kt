// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.UInt64Value in io/k8s/cri_api.proto
package runtime.v1alpha2

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireField
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.hashCode
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * UInt64Value is the wrapper of uint64.
 */
class UInt64Value(
  /**
   * The value.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#UINT64",
    label = WireField.Label.OMIT_IDENTITY
  )
  val value: Long = 0L,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<UInt64Value, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is UInt64Value) return false
    if (unknownFields != other.unknownFields) return false
    if (value != other.value) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + value.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """value=$value"""
    return result.joinToString(prefix = "UInt64Value{", separator = ", ", postfix = "}")
  }

  fun copy(value: Long = this.value, unknownFields: ByteString = this.unknownFields): UInt64Value =
      UInt64Value(value, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<UInt64Value> = object : ProtoAdapter<UInt64Value>(
      FieldEncoding.LENGTH_DELIMITED, 
      UInt64Value::class, 
      "type.googleapis.com/runtime.v1alpha2.UInt64Value", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: UInt64Value): Int {
        var size = value.unknownFields.size
        if (value.value != 0L) size += ProtoAdapter.UINT64.encodedSizeWithTag(1, value.value)
        return size
      }

      override fun encode(writer: ProtoWriter, value: UInt64Value) {
        if (value.value != 0L) ProtoAdapter.UINT64.encodeWithTag(writer, 1, value.value)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): UInt64Value {
        var value: Long = 0L
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> value = ProtoAdapter.UINT64.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return UInt64Value(
          value = value,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: UInt64Value): UInt64Value = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}