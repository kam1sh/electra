// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.NetworkConfig in io/k8s/cri_api.proto
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

class NetworkConfig(
  /**
   * CIDR to use for pod IP addresses. If the CIDR is empty, runtimes
   * should omit it.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "podCidr"
  )
  val pod_cidr: String = "",
  unknownFields: ByteString = ByteString.EMPTY
) : Message<NetworkConfig, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is NetworkConfig) return false
    if (unknownFields != other.unknownFields) return false
    if (pod_cidr != other.pod_cidr) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + pod_cidr.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """pod_cidr=${sanitize(pod_cidr)}"""
    return result.joinToString(prefix = "NetworkConfig{", separator = ", ", postfix = "}")
  }

  fun copy(pod_cidr: String = this.pod_cidr, unknownFields: ByteString = this.unknownFields):
      NetworkConfig = NetworkConfig(pod_cidr, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<NetworkConfig> = object : ProtoAdapter<NetworkConfig>(
      FieldEncoding.LENGTH_DELIMITED, 
      NetworkConfig::class, 
      "type.googleapis.com/runtime.v1alpha2.NetworkConfig", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: NetworkConfig): Int {
        var size = value.unknownFields.size
        if (value.pod_cidr != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.pod_cidr)
        return size
      }

      override fun encode(writer: ProtoWriter, value: NetworkConfig) {
        if (value.pod_cidr != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.pod_cidr)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): NetworkConfig {
        var pod_cidr: String = ""
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> pod_cidr = ProtoAdapter.STRING.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return NetworkConfig(
          pod_cidr = pod_cidr,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: NetworkConfig): NetworkConfig = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
