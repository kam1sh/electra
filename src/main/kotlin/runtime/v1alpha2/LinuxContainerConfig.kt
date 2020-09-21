// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.LinuxContainerConfig in io/k8s/cri_api.proto
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
 * LinuxContainerConfig contains platform-specific configuration for
 * Linux-based containers.
 */
class LinuxContainerConfig(
  /**
   * Resources specification for the container.
   */
  @field:WireField(
    tag = 1,
    adapter = "runtime.v1alpha2.LinuxContainerResources#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY
  )
  val resources: LinuxContainerResources? = null,
  /**
   * LinuxContainerSecurityContext configuration for the container.
   */
  @field:WireField(
    tag = 2,
    adapter = "runtime.v1alpha2.LinuxContainerSecurityContext#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "securityContext"
  )
  val security_context: LinuxContainerSecurityContext? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<LinuxContainerConfig, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is LinuxContainerConfig) return false
    if (unknownFields != other.unknownFields) return false
    if (resources != other.resources) return false
    if (security_context != other.security_context) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + resources.hashCode()
      result = result * 37 + security_context.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (resources != null) result += """resources=$resources"""
    if (security_context != null) result += """security_context=$security_context"""
    return result.joinToString(prefix = "LinuxContainerConfig{", separator = ", ", postfix = "}")
  }

  fun copy(
    resources: LinuxContainerResources? = this.resources,
    security_context: LinuxContainerSecurityContext? = this.security_context,
    unknownFields: ByteString = this.unknownFields
  ): LinuxContainerConfig = LinuxContainerConfig(resources, security_context, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<LinuxContainerConfig> = object : ProtoAdapter<LinuxContainerConfig>(
      FieldEncoding.LENGTH_DELIMITED, 
      LinuxContainerConfig::class, 
      "type.googleapis.com/runtime.v1alpha2.LinuxContainerConfig", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: LinuxContainerConfig): Int {
        var size = value.unknownFields.size
        if (value.resources != null) size += LinuxContainerResources.ADAPTER.encodedSizeWithTag(1,
            value.resources)
        if (value.security_context != null) size +=
            LinuxContainerSecurityContext.ADAPTER.encodedSizeWithTag(2, value.security_context)
        return size
      }

      override fun encode(writer: ProtoWriter, value: LinuxContainerConfig) {
        if (value.resources != null) LinuxContainerResources.ADAPTER.encodeWithTag(writer, 1,
            value.resources)
        if (value.security_context != null)
            LinuxContainerSecurityContext.ADAPTER.encodeWithTag(writer, 2, value.security_context)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): LinuxContainerConfig {
        var resources: LinuxContainerResources? = null
        var security_context: LinuxContainerSecurityContext? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> resources = LinuxContainerResources.ADAPTER.decode(reader)
            2 -> security_context = LinuxContainerSecurityContext.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return LinuxContainerConfig(
          resources = resources,
          security_context = security_context,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: LinuxContainerConfig): LinuxContainerConfig = value.copy(
        resources = value.resources?.let(LinuxContainerResources.ADAPTER::redact),
        security_context =
            value.security_context?.let(LinuxContainerSecurityContext.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
