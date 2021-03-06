// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.ExecSyncRequest in io/k8s/cri_api.proto
package runtime.v1alpha2

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireField
import com.squareup.wire.internal.immutableCopyOf
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
import kotlin.collections.List
import kotlin.hashCode
import kotlin.jvm.JvmField
import okio.ByteString

class ExecSyncRequest(
  /**
   * ID of the container.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "containerId"
  )
  val container_id: String = "",
  cmd: List<String> = emptyList(),
  /**
   * Timeout in seconds to stop the command. Default: 0 (run forever).
   */
  @field:WireField(
    tag = 3,
    adapter = "com.squareup.wire.ProtoAdapter#INT64",
    label = WireField.Label.OMIT_IDENTITY
  )
  val timeout: Long = 0L,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<ExecSyncRequest, Nothing>(ADAPTER, unknownFields) {
  /**
   * Command to execute.
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.REPEATED
  )
  val cmd: List<String> = immutableCopyOf("cmd", cmd)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is ExecSyncRequest) return false
    if (unknownFields != other.unknownFields) return false
    if (container_id != other.container_id) return false
    if (cmd != other.cmd) return false
    if (timeout != other.timeout) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + container_id.hashCode()
      result = result * 37 + cmd.hashCode()
      result = result * 37 + timeout.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """container_id=${sanitize(container_id)}"""
    if (cmd.isNotEmpty()) result += """cmd=${sanitize(cmd)}"""
    result += """timeout=$timeout"""
    return result.joinToString(prefix = "ExecSyncRequest{", separator = ", ", postfix = "}")
  }

  fun copy(
    container_id: String = this.container_id,
    cmd: List<String> = this.cmd,
    timeout: Long = this.timeout,
    unknownFields: ByteString = this.unknownFields
  ): ExecSyncRequest = ExecSyncRequest(container_id, cmd, timeout, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<ExecSyncRequest> = object : ProtoAdapter<ExecSyncRequest>(
      FieldEncoding.LENGTH_DELIMITED, 
      ExecSyncRequest::class, 
      "type.googleapis.com/runtime.v1alpha2.ExecSyncRequest", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: ExecSyncRequest): Int {
        var size = value.unknownFields.size
        if (value.container_id != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1,
            value.container_id)
        size += ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, value.cmd)
        if (value.timeout != 0L) size += ProtoAdapter.INT64.encodedSizeWithTag(3, value.timeout)
        return size
      }

      override fun encode(writer: ProtoWriter, value: ExecSyncRequest) {
        if (value.container_id != "") ProtoAdapter.STRING.encodeWithTag(writer, 1,
            value.container_id)
        ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 2, value.cmd)
        if (value.timeout != 0L) ProtoAdapter.INT64.encodeWithTag(writer, 3, value.timeout)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): ExecSyncRequest {
        var container_id: String = ""
        val cmd = mutableListOf<String>()
        var timeout: Long = 0L
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> container_id = ProtoAdapter.STRING.decode(reader)
            2 -> cmd.add(ProtoAdapter.STRING.decode(reader))
            3 -> timeout = ProtoAdapter.INT64.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return ExecSyncRequest(
          container_id = container_id,
          cmd = cmd,
          timeout = timeout,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: ExecSyncRequest): ExecSyncRequest = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
