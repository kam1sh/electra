// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.Namespace in io/k8s/cri_api.proto
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
 * Namespace contains paths to the namespaces.
 */
class Namespace(
  /**
   * Namespace options for Linux namespaces.
   */
  @field:WireField(
    tag = 2,
    adapter = "runtime.v1alpha2.NamespaceOption#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY
  )
  val options: NamespaceOption? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<Namespace, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is Namespace) return false
    if (unknownFields != other.unknownFields) return false
    if (options != other.options) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + options.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (options != null) result += """options=$options"""
    return result.joinToString(prefix = "Namespace{", separator = ", ", postfix = "}")
  }

  fun copy(options: NamespaceOption? = this.options, unknownFields: ByteString =
      this.unknownFields): Namespace = Namespace(options, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<Namespace> = object : ProtoAdapter<Namespace>(
      FieldEncoding.LENGTH_DELIMITED, 
      Namespace::class, 
      "type.googleapis.com/runtime.v1alpha2.Namespace", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: Namespace): Int {
        var size = value.unknownFields.size
        if (value.options != null) size += NamespaceOption.ADAPTER.encodedSizeWithTag(2,
            value.options)
        return size
      }

      override fun encode(writer: ProtoWriter, value: Namespace) {
        if (value.options != null) NamespaceOption.ADAPTER.encodeWithTag(writer, 2, value.options)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): Namespace {
        var options: NamespaceOption? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            2 -> options = NamespaceOption.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return Namespace(
          options = options,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: Namespace): Namespace = value.copy(
        options = value.options?.let(NamespaceOption.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}