// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.StopContainerRequest in io/k8s/cri_api.proto
package runtime.v1alpha2

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireField
import com.squareup.wire.internal.sanitize
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

class StopContainerRequest(
  /**
   * ID of the container to stop.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "containerId"
  )
  val container_id: String = "",
  /**
   * Timeout in seconds to wait for the container to stop before forcibly
   * terminating it. Default: 0 (forcibly terminate the container immediately)
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#INT64",
    label = WireField.Label.OMIT_IDENTITY
  )
  val timeout: Long = 0L,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<StopContainerRequest, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is StopContainerRequest) return false
    if (unknownFields != other.unknownFields) return false
    if (container_id != other.container_id) return false
    if (timeout != other.timeout) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + container_id.hashCode()
      result = result * 37 + timeout.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """container_id=${sanitize(container_id)}"""
    result += """timeout=$timeout"""
    return result.joinToString(prefix = "StopContainerRequest{", separator = ", ", postfix = "}")
  }

  fun copy(
    container_id: String = this.container_id,
    timeout: Long = this.timeout,
    unknownFields: ByteString = this.unknownFields
  ): StopContainerRequest = StopContainerRequest(container_id, timeout, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<StopContainerRequest> = object : ProtoAdapter<StopContainerRequest>(
      FieldEncoding.LENGTH_DELIMITED, 
      StopContainerRequest::class, 
      "type.googleapis.com/runtime.v1alpha2.StopContainerRequest", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: StopContainerRequest): Int {
        var size = value.unknownFields.size
        if (value.container_id != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1,
            value.container_id)
        if (value.timeout != 0L) size += ProtoAdapter.INT64.encodedSizeWithTag(2, value.timeout)
        return size
      }

      override fun encode(writer: ProtoWriter, value: StopContainerRequest) {
        if (value.container_id != "") ProtoAdapter.STRING.encodeWithTag(writer, 1,
            value.container_id)
        if (value.timeout != 0L) ProtoAdapter.INT64.encodeWithTag(writer, 2, value.timeout)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): StopContainerRequest {
        var container_id: String = ""
        var timeout: Long = 0L
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> container_id = ProtoAdapter.STRING.decode(reader)
            2 -> timeout = ProtoAdapter.INT64.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return StopContainerRequest(
          container_id = container_id,
          timeout = timeout,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: StopContainerRequest): StopContainerRequest = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
