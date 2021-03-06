// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.RemovePodSandboxResponse in io/k8s/cri_api.proto
package runtime.v1alpha2

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax.PROTO_3
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.jvm.JvmField
import okio.ByteString

class RemovePodSandboxResponse(
  unknownFields: ByteString = ByteString.EMPTY
) : Message<RemovePodSandboxResponse, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is RemovePodSandboxResponse) return false
    if (unknownFields != other.unknownFields) return false
    return true
  }

  override fun hashCode(): Int = unknownFields.hashCode()

  override fun toString(): String = "RemovePodSandboxResponse{}"

  fun copy(unknownFields: ByteString = this.unknownFields): RemovePodSandboxResponse =
      RemovePodSandboxResponse(unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<RemovePodSandboxResponse> = object :
        ProtoAdapter<RemovePodSandboxResponse>(
      FieldEncoding.LENGTH_DELIMITED, 
      RemovePodSandboxResponse::class, 
      "type.googleapis.com/runtime.v1alpha2.RemovePodSandboxResponse", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: RemovePodSandboxResponse): Int {
        var size = value.unknownFields.size
        return size
      }

      override fun encode(writer: ProtoWriter, value: RemovePodSandboxResponse) {
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): RemovePodSandboxResponse {
        val unknownFields = reader.forEachTag(reader::readUnknownField)
        return RemovePodSandboxResponse(
          unknownFields = unknownFields
        )
      }

      override fun redact(value: RemovePodSandboxResponse): RemovePodSandboxResponse = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
