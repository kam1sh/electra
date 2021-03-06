// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.PodSandboxStatusRequest in io/k8s/cri_api.proto
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

class PodSandboxStatusRequest(
  /**
   * ID of the PodSandbox for which to retrieve status.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "podSandboxId"
  )
  val pod_sandbox_id: String = "",
  /**
   * Verbose indicates whether to return extra information about the pod sandbox.
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
    label = WireField.Label.OMIT_IDENTITY
  )
  val verbose: Boolean = false,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<PodSandboxStatusRequest, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is PodSandboxStatusRequest) return false
    if (unknownFields != other.unknownFields) return false
    if (pod_sandbox_id != other.pod_sandbox_id) return false
    if (verbose != other.verbose) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + pod_sandbox_id.hashCode()
      result = result * 37 + verbose.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """pod_sandbox_id=${sanitize(pod_sandbox_id)}"""
    result += """verbose=$verbose"""
    return result.joinToString(prefix = "PodSandboxStatusRequest{", separator = ", ", postfix = "}")
  }

  fun copy(
    pod_sandbox_id: String = this.pod_sandbox_id,
    verbose: Boolean = this.verbose,
    unknownFields: ByteString = this.unknownFields
  ): PodSandboxStatusRequest = PodSandboxStatusRequest(pod_sandbox_id, verbose, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<PodSandboxStatusRequest> = object :
        ProtoAdapter<PodSandboxStatusRequest>(
      FieldEncoding.LENGTH_DELIMITED, 
      PodSandboxStatusRequest::class, 
      "type.googleapis.com/runtime.v1alpha2.PodSandboxStatusRequest", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: PodSandboxStatusRequest): Int {
        var size = value.unknownFields.size
        if (value.pod_sandbox_id != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1,
            value.pod_sandbox_id)
        if (value.verbose != false) size += ProtoAdapter.BOOL.encodedSizeWithTag(2, value.verbose)
        return size
      }

      override fun encode(writer: ProtoWriter, value: PodSandboxStatusRequest) {
        if (value.pod_sandbox_id != "") ProtoAdapter.STRING.encodeWithTag(writer, 1,
            value.pod_sandbox_id)
        if (value.verbose != false) ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.verbose)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): PodSandboxStatusRequest {
        var pod_sandbox_id: String = ""
        var verbose: Boolean = false
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> pod_sandbox_id = ProtoAdapter.STRING.decode(reader)
            2 -> verbose = ProtoAdapter.BOOL.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return PodSandboxStatusRequest(
          pod_sandbox_id = pod_sandbox_id,
          verbose = verbose,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: PodSandboxStatusRequest): PodSandboxStatusRequest = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
