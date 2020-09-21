// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.ContainerStatsResponse in io/k8s/cri_api.proto
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

class ContainerStatsResponse(
  /**
   * Stats of the container.
   */
  @field:WireField(
    tag = 1,
    adapter = "runtime.v1alpha2.ContainerStats#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY
  )
  val stats: ContainerStats? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<ContainerStatsResponse, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is ContainerStatsResponse) return false
    if (unknownFields != other.unknownFields) return false
    if (stats != other.stats) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + stats.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (stats != null) result += """stats=$stats"""
    return result.joinToString(prefix = "ContainerStatsResponse{", separator = ", ", postfix = "}")
  }

  fun copy(stats: ContainerStats? = this.stats, unknownFields: ByteString = this.unknownFields):
      ContainerStatsResponse = ContainerStatsResponse(stats, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<ContainerStatsResponse> = object :
        ProtoAdapter<ContainerStatsResponse>(
      FieldEncoding.LENGTH_DELIMITED, 
      ContainerStatsResponse::class, 
      "type.googleapis.com/runtime.v1alpha2.ContainerStatsResponse", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: ContainerStatsResponse): Int {
        var size = value.unknownFields.size
        if (value.stats != null) size += ContainerStats.ADAPTER.encodedSizeWithTag(1, value.stats)
        return size
      }

      override fun encode(writer: ProtoWriter, value: ContainerStatsResponse) {
        if (value.stats != null) ContainerStats.ADAPTER.encodeWithTag(writer, 1, value.stats)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): ContainerStatsResponse {
        var stats: ContainerStats? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> stats = ContainerStats.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return ContainerStatsResponse(
          stats = stats,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: ContainerStatsResponse): ContainerStatsResponse = value.copy(
        stats = value.stats?.let(ContainerStats.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}