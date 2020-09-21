// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.RunPodSandboxRequest in io/k8s/cri_api.proto
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

class RunPodSandboxRequest(
  /**
   * Configuration for creating a PodSandbox.
   */
  @field:WireField(
    tag = 1,
    adapter = "runtime.v1alpha2.PodSandboxConfig#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY
  )
  val config: PodSandboxConfig? = null,
  /**
   * Named runtime configuration to use for this PodSandbox.
   * If the runtime handler is unknown, this request should be rejected.  An
   * empty string should select the default handler, equivalent to the
   * behavior before this feature was added.
   * See https://git.k8s.io/enhancements/keps/sig-node/runtime-class.md
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "runtimeHandler"
  )
  val runtime_handler: String = "",
  unknownFields: ByteString = ByteString.EMPTY
) : Message<RunPodSandboxRequest, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is RunPodSandboxRequest) return false
    if (unknownFields != other.unknownFields) return false
    if (config != other.config) return false
    if (runtime_handler != other.runtime_handler) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + config.hashCode()
      result = result * 37 + runtime_handler.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (config != null) result += """config=$config"""
    result += """runtime_handler=${sanitize(runtime_handler)}"""
    return result.joinToString(prefix = "RunPodSandboxRequest{", separator = ", ", postfix = "}")
  }

  fun copy(
    config: PodSandboxConfig? = this.config,
    runtime_handler: String = this.runtime_handler,
    unknownFields: ByteString = this.unknownFields
  ): RunPodSandboxRequest = RunPodSandboxRequest(config, runtime_handler, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<RunPodSandboxRequest> = object : ProtoAdapter<RunPodSandboxRequest>(
      FieldEncoding.LENGTH_DELIMITED, 
      RunPodSandboxRequest::class, 
      "type.googleapis.com/runtime.v1alpha2.RunPodSandboxRequest", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: RunPodSandboxRequest): Int {
        var size = value.unknownFields.size
        if (value.config != null) size += PodSandboxConfig.ADAPTER.encodedSizeWithTag(1,
            value.config)
        if (value.runtime_handler != "") size += ProtoAdapter.STRING.encodedSizeWithTag(2,
            value.runtime_handler)
        return size
      }

      override fun encode(writer: ProtoWriter, value: RunPodSandboxRequest) {
        if (value.config != null) PodSandboxConfig.ADAPTER.encodeWithTag(writer, 1, value.config)
        if (value.runtime_handler != "") ProtoAdapter.STRING.encodeWithTag(writer, 2,
            value.runtime_handler)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): RunPodSandboxRequest {
        var config: PodSandboxConfig? = null
        var runtime_handler: String = ""
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> config = PodSandboxConfig.ADAPTER.decode(reader)
            2 -> runtime_handler = ProtoAdapter.STRING.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return RunPodSandboxRequest(
          config = config,
          runtime_handler = runtime_handler,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: RunPodSandboxRequest): RunPodSandboxRequest = value.copy(
        config = value.config?.let(PodSandboxConfig.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
