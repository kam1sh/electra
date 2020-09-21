// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.RemovePodSandboxRequest in io/k8s/cri_api.proto
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

class RemovePodSandboxRequest(
  /**
   * ID of the PodSandbox to remove.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "podSandboxId"
  )
  val pod_sandbox_id: String = "",
  unknownFields: ByteString = ByteString.EMPTY
) : Message<RemovePodSandboxRequest, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is RemovePodSandboxRequest) return false
    if (unknownFields != other.unknownFields) return false
    if (pod_sandbox_id != other.pod_sandbox_id) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + pod_sandbox_id.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """pod_sandbox_id=${sanitize(pod_sandbox_id)}"""
    return result.joinToString(prefix = "RemovePodSandboxRequest{", separator = ", ", postfix = "}")
  }

  fun copy(pod_sandbox_id: String = this.pod_sandbox_id, unknownFields: ByteString =
      this.unknownFields): RemovePodSandboxRequest = RemovePodSandboxRequest(pod_sandbox_id,
      unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<RemovePodSandboxRequest> = object :
        ProtoAdapter<RemovePodSandboxRequest>(
      FieldEncoding.LENGTH_DELIMITED, 
      RemovePodSandboxRequest::class, 
      "type.googleapis.com/runtime.v1alpha2.RemovePodSandboxRequest", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: RemovePodSandboxRequest): Int {
        var size = value.unknownFields.size
        if (value.pod_sandbox_id != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1,
            value.pod_sandbox_id)
        return size
      }

      override fun encode(writer: ProtoWriter, value: RemovePodSandboxRequest) {
        if (value.pod_sandbox_id != "") ProtoAdapter.STRING.encodeWithTag(writer, 1,
            value.pod_sandbox_id)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): RemovePodSandboxRequest {
        var pod_sandbox_id: String = ""
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> pod_sandbox_id = ProtoAdapter.STRING.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return RemovePodSandboxRequest(
          pod_sandbox_id = pod_sandbox_id,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: RemovePodSandboxRequest): RemovePodSandboxRequest = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
