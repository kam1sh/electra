// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.ListPodSandboxRequest in io/k8s/cri_api.proto
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

class ListPodSandboxRequest(
  /**
   * PodSandboxFilter to filter a list of PodSandboxes.
   */
  @field:WireField(
    tag = 1,
    adapter = "runtime.v1alpha2.PodSandboxFilter#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY
  )
  val filter: PodSandboxFilter? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<ListPodSandboxRequest, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is ListPodSandboxRequest) return false
    if (unknownFields != other.unknownFields) return false
    if (filter != other.filter) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + filter.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (filter != null) result += """filter=$filter"""
    return result.joinToString(prefix = "ListPodSandboxRequest{", separator = ", ", postfix = "}")
  }

  fun copy(filter: PodSandboxFilter? = this.filter, unknownFields: ByteString = this.unknownFields):
      ListPodSandboxRequest = ListPodSandboxRequest(filter, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<ListPodSandboxRequest> = object : ProtoAdapter<ListPodSandboxRequest>(
      FieldEncoding.LENGTH_DELIMITED, 
      ListPodSandboxRequest::class, 
      "type.googleapis.com/runtime.v1alpha2.ListPodSandboxRequest", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: ListPodSandboxRequest): Int {
        var size = value.unknownFields.size
        if (value.filter != null) size += PodSandboxFilter.ADAPTER.encodedSizeWithTag(1,
            value.filter)
        return size
      }

      override fun encode(writer: ProtoWriter, value: ListPodSandboxRequest) {
        if (value.filter != null) PodSandboxFilter.ADAPTER.encodeWithTag(writer, 1, value.filter)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): ListPodSandboxRequest {
        var filter: PodSandboxFilter? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> filter = PodSandboxFilter.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return ListPodSandboxRequest(
          filter = filter,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: ListPodSandboxRequest): ListPodSandboxRequest = value.copy(
        filter = value.filter?.let(PodSandboxFilter.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}