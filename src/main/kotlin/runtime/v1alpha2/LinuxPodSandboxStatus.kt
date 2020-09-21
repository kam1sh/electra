// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.LinuxPodSandboxStatus in io/k8s/cri_api.proto
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
 * LinuxSandboxStatus contains status specific to Linux sandboxes.
 */
class LinuxPodSandboxStatus(
  /**
   * Paths to the sandbox's namespaces.
   */
  @field:WireField(
    tag = 1,
    adapter = "runtime.v1alpha2.Namespace#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY
  )
  val namespaces: Namespace? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<LinuxPodSandboxStatus, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is LinuxPodSandboxStatus) return false
    if (unknownFields != other.unknownFields) return false
    if (namespaces != other.namespaces) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + namespaces.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (namespaces != null) result += """namespaces=$namespaces"""
    return result.joinToString(prefix = "LinuxPodSandboxStatus{", separator = ", ", postfix = "}")
  }

  fun copy(namespaces: Namespace? = this.namespaces, unknownFields: ByteString =
      this.unknownFields): LinuxPodSandboxStatus = LinuxPodSandboxStatus(namespaces, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<LinuxPodSandboxStatus> = object : ProtoAdapter<LinuxPodSandboxStatus>(
      FieldEncoding.LENGTH_DELIMITED, 
      LinuxPodSandboxStatus::class, 
      "type.googleapis.com/runtime.v1alpha2.LinuxPodSandboxStatus", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: LinuxPodSandboxStatus): Int {
        var size = value.unknownFields.size
        if (value.namespaces != null) size += Namespace.ADAPTER.encodedSizeWithTag(1,
            value.namespaces)
        return size
      }

      override fun encode(writer: ProtoWriter, value: LinuxPodSandboxStatus) {
        if (value.namespaces != null) Namespace.ADAPTER.encodeWithTag(writer, 1, value.namespaces)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): LinuxPodSandboxStatus {
        var namespaces: Namespace? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> namespaces = Namespace.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return LinuxPodSandboxStatus(
          namespaces = namespaces,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: LinuxPodSandboxStatus): LinuxPodSandboxStatus = value.copy(
        namespaces = value.namespaces?.let(Namespace.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
