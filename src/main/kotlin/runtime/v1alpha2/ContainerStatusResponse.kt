// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.ContainerStatusResponse in io/k8s/cri_api.proto
package runtime.v1alpha2

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireField
import com.squareup.wire.internal.immutableCopyOf
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.Map
import kotlin.hashCode
import kotlin.jvm.JvmField
import kotlin.lazy
import okio.ByteString

class ContainerStatusResponse(
  /**
   * Status of the container.
   */
  @field:WireField(
    tag = 1,
    adapter = "runtime.v1alpha2.ContainerStatus#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY
  )
  val status: ContainerStatus? = null,
  info: Map<String, String> = emptyMap(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<ContainerStatusResponse, Nothing>(ADAPTER, unknownFields) {
  /**
   * Info is extra information of the Container. The key could be arbitrary string, and
   * value should be in json format. The information could include anything useful for
   * debug, e.g. pid for linux container based container runtime.
   * It should only be returned non-empty when Verbose is true.
   */
  @field:WireField(
    tag = 2,
    keyAdapter = "com.squareup.wire.ProtoAdapter#STRING",
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  val info: Map<String, String> = immutableCopyOf("info", info)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is ContainerStatusResponse) return false
    if (unknownFields != other.unknownFields) return false
    if (status != other.status) return false
    if (info != other.info) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + status.hashCode()
      result = result * 37 + info.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (status != null) result += """status=$status"""
    if (info.isNotEmpty()) result += """info=$info"""
    return result.joinToString(prefix = "ContainerStatusResponse{", separator = ", ", postfix = "}")
  }

  fun copy(
    status: ContainerStatus? = this.status,
    info: Map<String, String> = this.info,
    unknownFields: ByteString = this.unknownFields
  ): ContainerStatusResponse = ContainerStatusResponse(status, info, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<ContainerStatusResponse> = object :
        ProtoAdapter<ContainerStatusResponse>(
      FieldEncoding.LENGTH_DELIMITED, 
      ContainerStatusResponse::class, 
      "type.googleapis.com/runtime.v1alpha2.ContainerStatusResponse", 
      PROTO_3, 
      null
    ) {
      private val infoAdapter: ProtoAdapter<Map<String, String>> by lazy {
          ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING) }

      override fun encodedSize(value: ContainerStatusResponse): Int {
        var size = value.unknownFields.size
        if (value.status != null) size += ContainerStatus.ADAPTER.encodedSizeWithTag(1,
            value.status)
        size += infoAdapter.encodedSizeWithTag(2, value.info)
        return size
      }

      override fun encode(writer: ProtoWriter, value: ContainerStatusResponse) {
        if (value.status != null) ContainerStatus.ADAPTER.encodeWithTag(writer, 1, value.status)
        infoAdapter.encodeWithTag(writer, 2, value.info)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): ContainerStatusResponse {
        var status: ContainerStatus? = null
        val info = mutableMapOf<String, String>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> status = ContainerStatus.ADAPTER.decode(reader)
            2 -> info.putAll(infoAdapter.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return ContainerStatusResponse(
          status = status,
          info = info,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: ContainerStatusResponse): ContainerStatusResponse = value.copy(
        status = value.status?.let(ContainerStatus.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
