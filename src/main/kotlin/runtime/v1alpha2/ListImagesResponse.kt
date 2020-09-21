// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.ListImagesResponse in io/k8s/cri_api.proto
package runtime.v1alpha2

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireField
import com.squareup.wire.internal.immutableCopyOf
import com.squareup.wire.internal.redactElements
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
import kotlin.jvm.JvmField
import okio.ByteString

class ListImagesResponse(
  images: List<Image> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<ListImagesResponse, Nothing>(ADAPTER, unknownFields) {
  /**
   * List of images.
   */
  @field:WireField(
    tag = 1,
    adapter = "runtime.v1alpha2.Image#ADAPTER",
    label = WireField.Label.REPEATED
  )
  val images: List<Image> = immutableCopyOf("images", images)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is ListImagesResponse) return false
    if (unknownFields != other.unknownFields) return false
    if (images != other.images) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + images.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (images.isNotEmpty()) result += """images=$images"""
    return result.joinToString(prefix = "ListImagesResponse{", separator = ", ", postfix = "}")
  }

  fun copy(images: List<Image> = this.images, unknownFields: ByteString = this.unknownFields):
      ListImagesResponse = ListImagesResponse(images, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<ListImagesResponse> = object : ProtoAdapter<ListImagesResponse>(
      FieldEncoding.LENGTH_DELIMITED, 
      ListImagesResponse::class, 
      "type.googleapis.com/runtime.v1alpha2.ListImagesResponse", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: ListImagesResponse): Int {
        var size = value.unknownFields.size
        size += Image.ADAPTER.asRepeated().encodedSizeWithTag(1, value.images)
        return size
      }

      override fun encode(writer: ProtoWriter, value: ListImagesResponse) {
        Image.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.images)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): ListImagesResponse {
        val images = mutableListOf<Image>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> images.add(Image.ADAPTER.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return ListImagesResponse(
          images = images,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: ListImagesResponse): ListImagesResponse = value.copy(
        images = value.images.redactElements(Image.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
