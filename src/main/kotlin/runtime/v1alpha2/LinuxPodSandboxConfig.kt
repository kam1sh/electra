// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.LinuxPodSandboxConfig in io/k8s/cri_api.proto
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
import kotlin.collections.Map
import kotlin.hashCode
import kotlin.jvm.JvmField
import kotlin.lazy
import okio.ByteString

/**
 * LinuxPodSandboxConfig holds platform-specific configurations for Linux
 * host platforms and Linux-based containers.
 */
class LinuxPodSandboxConfig(
  /**
   * Parent cgroup of the PodSandbox.
   * The cgroupfs style syntax will be used, but the container runtime can
   * convert it to systemd semantics if needed.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "cgroupParent"
  )
  val cgroup_parent: String = "",
  /**
   * LinuxSandboxSecurityContext holds sandbox security attributes.
   */
  @field:WireField(
    tag = 2,
    adapter = "runtime.v1alpha2.LinuxSandboxSecurityContext#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "securityContext"
  )
  val security_context: LinuxSandboxSecurityContext? = null,
  sysctls: Map<String, String> = emptyMap(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<LinuxPodSandboxConfig, Nothing>(ADAPTER, unknownFields) {
  /**
   * Sysctls holds linux sysctls config for the sandbox.
   */
  @field:WireField(
    tag = 3,
    keyAdapter = "com.squareup.wire.ProtoAdapter#STRING",
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  val sysctls: Map<String, String> = immutableCopyOf("sysctls", sysctls)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is LinuxPodSandboxConfig) return false
    if (unknownFields != other.unknownFields) return false
    if (cgroup_parent != other.cgroup_parent) return false
    if (security_context != other.security_context) return false
    if (sysctls != other.sysctls) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + cgroup_parent.hashCode()
      result = result * 37 + security_context.hashCode()
      result = result * 37 + sysctls.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """cgroup_parent=${sanitize(cgroup_parent)}"""
    if (security_context != null) result += """security_context=$security_context"""
    if (sysctls.isNotEmpty()) result += """sysctls=$sysctls"""
    return result.joinToString(prefix = "LinuxPodSandboxConfig{", separator = ", ", postfix = "}")
  }

  fun copy(
    cgroup_parent: String = this.cgroup_parent,
    security_context: LinuxSandboxSecurityContext? = this.security_context,
    sysctls: Map<String, String> = this.sysctls,
    unknownFields: ByteString = this.unknownFields
  ): LinuxPodSandboxConfig = LinuxPodSandboxConfig(cgroup_parent, security_context, sysctls,
      unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<LinuxPodSandboxConfig> = object : ProtoAdapter<LinuxPodSandboxConfig>(
      FieldEncoding.LENGTH_DELIMITED, 
      LinuxPodSandboxConfig::class, 
      "type.googleapis.com/runtime.v1alpha2.LinuxPodSandboxConfig", 
      PROTO_3, 
      null
    ) {
      private val sysctlsAdapter: ProtoAdapter<Map<String, String>> by lazy {
          ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING) }

      override fun encodedSize(value: LinuxPodSandboxConfig): Int {
        var size = value.unknownFields.size
        if (value.cgroup_parent != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1,
            value.cgroup_parent)
        if (value.security_context != null) size +=
            LinuxSandboxSecurityContext.ADAPTER.encodedSizeWithTag(2, value.security_context)
        size += sysctlsAdapter.encodedSizeWithTag(3, value.sysctls)
        return size
      }

      override fun encode(writer: ProtoWriter, value: LinuxPodSandboxConfig) {
        if (value.cgroup_parent != "") ProtoAdapter.STRING.encodeWithTag(writer, 1,
            value.cgroup_parent)
        if (value.security_context != null)
            LinuxSandboxSecurityContext.ADAPTER.encodeWithTag(writer, 2, value.security_context)
        sysctlsAdapter.encodeWithTag(writer, 3, value.sysctls)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): LinuxPodSandboxConfig {
        var cgroup_parent: String = ""
        var security_context: LinuxSandboxSecurityContext? = null
        val sysctls = mutableMapOf<String, String>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> cgroup_parent = ProtoAdapter.STRING.decode(reader)
            2 -> security_context = LinuxSandboxSecurityContext.ADAPTER.decode(reader)
            3 -> sysctls.putAll(sysctlsAdapter.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return LinuxPodSandboxConfig(
          cgroup_parent = cgroup_parent,
          security_context = security_context,
          sysctls = sysctls,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: LinuxPodSandboxConfig): LinuxPodSandboxConfig = value.copy(
        security_context = value.security_context?.let(LinuxSandboxSecurityContext.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}