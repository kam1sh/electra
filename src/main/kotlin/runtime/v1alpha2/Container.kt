// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.Container in io/k8s/cri_api.proto
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
 * Container provides the runtime information for a container, such as ID, hash,
 * state of the container.
 */
class Container(
  /**
   * ID of the container, used by the container runtime to identify
   * a container.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY
  )
  val id: String = "",
  /**
   * ID of the sandbox to which this container belongs.
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "podSandboxId"
  )
  val pod_sandbox_id: String = "",
  /**
   * Metadata of the container.
   */
  @field:WireField(
    tag = 3,
    adapter = "runtime.v1alpha2.ContainerMetadata#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY
  )
  val metadata: ContainerMetadata? = null,
  /**
   * Spec of the image.
   */
  @field:WireField(
    tag = 4,
    adapter = "runtime.v1alpha2.ImageSpec#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY
  )
  val image: ImageSpec? = null,
  /**
   * Reference to the image in use. For most runtimes, this should be an
   * image ID.
   */
  @field:WireField(
    tag = 5,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "imageRef"
  )
  val image_ref: String = "",
  /**
   * State of the container.
   */
  @field:WireField(
    tag = 6,
    adapter = "runtime.v1alpha2.ContainerState#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY
  )
  val state: ContainerState = ContainerState.CONTAINER_CREATED,
  /**
   * Creation time of the container in nanoseconds.
   */
  @field:WireField(
    tag = 7,
    adapter = "com.squareup.wire.ProtoAdapter#INT64",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "createdAt"
  )
  val created_at: Long = 0L,
  labels: Map<String, String> = emptyMap(),
  annotations: Map<String, String> = emptyMap(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<Container, Nothing>(ADAPTER, unknownFields) {
  /**
   * Key-value pairs that may be used to scope and select individual resources.
   */
  @field:WireField(
    tag = 8,
    keyAdapter = "com.squareup.wire.ProtoAdapter#STRING",
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  val labels: Map<String, String> = immutableCopyOf("labels", labels)

  /**
   * Unstructured key-value map holding arbitrary metadata.
   * Annotations MUST NOT be altered by the runtime; the value of this field
   * MUST be identical to that of the corresponding ContainerConfig used to
   * instantiate this Container.
   */
  @field:WireField(
    tag = 9,
    keyAdapter = "com.squareup.wire.ProtoAdapter#STRING",
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  val annotations: Map<String, String> = immutableCopyOf("annotations", annotations)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is Container) return false
    if (unknownFields != other.unknownFields) return false
    if (id != other.id) return false
    if (pod_sandbox_id != other.pod_sandbox_id) return false
    if (metadata != other.metadata) return false
    if (image != other.image) return false
    if (image_ref != other.image_ref) return false
    if (state != other.state) return false
    if (created_at != other.created_at) return false
    if (labels != other.labels) return false
    if (annotations != other.annotations) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + id.hashCode()
      result = result * 37 + pod_sandbox_id.hashCode()
      result = result * 37 + metadata.hashCode()
      result = result * 37 + image.hashCode()
      result = result * 37 + image_ref.hashCode()
      result = result * 37 + state.hashCode()
      result = result * 37 + created_at.hashCode()
      result = result * 37 + labels.hashCode()
      result = result * 37 + annotations.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """id=${sanitize(id)}"""
    result += """pod_sandbox_id=${sanitize(pod_sandbox_id)}"""
    if (metadata != null) result += """metadata=$metadata"""
    if (image != null) result += """image=$image"""
    result += """image_ref=${sanitize(image_ref)}"""
    result += """state=$state"""
    result += """created_at=$created_at"""
    if (labels.isNotEmpty()) result += """labels=$labels"""
    if (annotations.isNotEmpty()) result += """annotations=$annotations"""
    return result.joinToString(prefix = "Container{", separator = ", ", postfix = "}")
  }

  fun copy(
    id: String = this.id,
    pod_sandbox_id: String = this.pod_sandbox_id,
    metadata: ContainerMetadata? = this.metadata,
    image: ImageSpec? = this.image,
    image_ref: String = this.image_ref,
    state: ContainerState = this.state,
    created_at: Long = this.created_at,
    labels: Map<String, String> = this.labels,
    annotations: Map<String, String> = this.annotations,
    unknownFields: ByteString = this.unknownFields
  ): Container = Container(id, pod_sandbox_id, metadata, image, image_ref, state, created_at,
      labels, annotations, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<Container> = object : ProtoAdapter<Container>(
      FieldEncoding.LENGTH_DELIMITED, 
      Container::class, 
      "type.googleapis.com/runtime.v1alpha2.Container", 
      PROTO_3, 
      null
    ) {
      private val labelsAdapter: ProtoAdapter<Map<String, String>> by lazy {
          ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING) }

      private val annotationsAdapter: ProtoAdapter<Map<String, String>> by lazy {
          ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING) }

      override fun encodedSize(value: Container): Int {
        var size = value.unknownFields.size
        if (value.id != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.id)
        if (value.pod_sandbox_id != "") size += ProtoAdapter.STRING.encodedSizeWithTag(2,
            value.pod_sandbox_id)
        if (value.metadata != null) size += ContainerMetadata.ADAPTER.encodedSizeWithTag(3,
            value.metadata)
        if (value.image != null) size += ImageSpec.ADAPTER.encodedSizeWithTag(4, value.image)
        if (value.image_ref != "") size += ProtoAdapter.STRING.encodedSizeWithTag(5,
            value.image_ref)
        if (value.state != ContainerState.CONTAINER_CREATED) size +=
            ContainerState.ADAPTER.encodedSizeWithTag(6, value.state)
        if (value.created_at != 0L) size += ProtoAdapter.INT64.encodedSizeWithTag(7,
            value.created_at)
        size += labelsAdapter.encodedSizeWithTag(8, value.labels)
        size += annotationsAdapter.encodedSizeWithTag(9, value.annotations)
        return size
      }

      override fun encode(writer: ProtoWriter, value: Container) {
        if (value.id != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.id)
        if (value.pod_sandbox_id != "") ProtoAdapter.STRING.encodeWithTag(writer, 2,
            value.pod_sandbox_id)
        if (value.metadata != null) ContainerMetadata.ADAPTER.encodeWithTag(writer, 3,
            value.metadata)
        if (value.image != null) ImageSpec.ADAPTER.encodeWithTag(writer, 4, value.image)
        if (value.image_ref != "") ProtoAdapter.STRING.encodeWithTag(writer, 5, value.image_ref)
        if (value.state != ContainerState.CONTAINER_CREATED)
            ContainerState.ADAPTER.encodeWithTag(writer, 6, value.state)
        if (value.created_at != 0L) ProtoAdapter.INT64.encodeWithTag(writer, 7, value.created_at)
        labelsAdapter.encodeWithTag(writer, 8, value.labels)
        annotationsAdapter.encodeWithTag(writer, 9, value.annotations)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): Container {
        var id: String = ""
        var pod_sandbox_id: String = ""
        var metadata: ContainerMetadata? = null
        var image: ImageSpec? = null
        var image_ref: String = ""
        var state: ContainerState = ContainerState.CONTAINER_CREATED
        var created_at: Long = 0L
        val labels = mutableMapOf<String, String>()
        val annotations = mutableMapOf<String, String>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> id = ProtoAdapter.STRING.decode(reader)
            2 -> pod_sandbox_id = ProtoAdapter.STRING.decode(reader)
            3 -> metadata = ContainerMetadata.ADAPTER.decode(reader)
            4 -> image = ImageSpec.ADAPTER.decode(reader)
            5 -> image_ref = ProtoAdapter.STRING.decode(reader)
            6 -> try {
              state = ContainerState.ADAPTER.decode(reader)
            } catch (e: ProtoAdapter.EnumConstantNotFoundException) {
              reader.addUnknownField(tag, FieldEncoding.VARINT, e.value.toLong())
            }
            7 -> created_at = ProtoAdapter.INT64.decode(reader)
            8 -> labels.putAll(labelsAdapter.decode(reader))
            9 -> annotations.putAll(annotationsAdapter.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return Container(
          id = id,
          pod_sandbox_id = pod_sandbox_id,
          metadata = metadata,
          image = image,
          image_ref = image_ref,
          state = state,
          created_at = created_at,
          labels = labels,
          annotations = annotations,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: Container): Container = value.copy(
        metadata = value.metadata?.let(ContainerMetadata.ADAPTER::redact),
        image = value.image?.let(ImageSpec.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
