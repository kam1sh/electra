// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.ExecRequest in io/k8s/cri_api.proto
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
import kotlin.collections.List
import kotlin.hashCode
import kotlin.jvm.JvmField
import okio.ByteString

class ExecRequest(
  /**
   * ID of the container in which to execute the command.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "containerId"
  )
  val container_id: String = "",
  cmd: List<String> = emptyList(),
  /**
   * Whether to exec the command in a TTY.
   */
  @field:WireField(
    tag = 3,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
    label = WireField.Label.OMIT_IDENTITY
  )
  val tty: Boolean = false,
  /**
   * Whether to stream stdin.
   * One of `stdin`, `stdout`, and `stderr` MUST be true.
   */
  @field:WireField(
    tag = 4,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
    label = WireField.Label.OMIT_IDENTITY
  )
  val stdin: Boolean = false,
  /**
   * Whether to stream stdout.
   * One of `stdin`, `stdout`, and `stderr` MUST be true.
   */
  @field:WireField(
    tag = 5,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
    label = WireField.Label.OMIT_IDENTITY
  )
  val stdout: Boolean = false,
  /**
   * Whether to stream stderr.
   * One of `stdin`, `stdout`, and `stderr` MUST be true.
   * If `tty` is true, `stderr` MUST be false. Multiplexing is not supported
   * in this case. The output of stdout and stderr will be combined to a
   * single stream.
   */
  @field:WireField(
    tag = 6,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
    label = WireField.Label.OMIT_IDENTITY
  )
  val stderr: Boolean = false,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<ExecRequest, Nothing>(ADAPTER, unknownFields) {
  /**
   * Command to execute.
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.REPEATED
  )
  val cmd: List<String> = immutableCopyOf("cmd", cmd)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is ExecRequest) return false
    if (unknownFields != other.unknownFields) return false
    if (container_id != other.container_id) return false
    if (cmd != other.cmd) return false
    if (tty != other.tty) return false
    if (stdin != other.stdin) return false
    if (stdout != other.stdout) return false
    if (stderr != other.stderr) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + container_id.hashCode()
      result = result * 37 + cmd.hashCode()
      result = result * 37 + tty.hashCode()
      result = result * 37 + stdin.hashCode()
      result = result * 37 + stdout.hashCode()
      result = result * 37 + stderr.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """container_id=${sanitize(container_id)}"""
    if (cmd.isNotEmpty()) result += """cmd=${sanitize(cmd)}"""
    result += """tty=$tty"""
    result += """stdin=$stdin"""
    result += """stdout=$stdout"""
    result += """stderr=$stderr"""
    return result.joinToString(prefix = "ExecRequest{", separator = ", ", postfix = "}")
  }

  fun copy(
    container_id: String = this.container_id,
    cmd: List<String> = this.cmd,
    tty: Boolean = this.tty,
    stdin: Boolean = this.stdin,
    stdout: Boolean = this.stdout,
    stderr: Boolean = this.stderr,
    unknownFields: ByteString = this.unknownFields
  ): ExecRequest = ExecRequest(container_id, cmd, tty, stdin, stdout, stderr, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<ExecRequest> = object : ProtoAdapter<ExecRequest>(
      FieldEncoding.LENGTH_DELIMITED, 
      ExecRequest::class, 
      "type.googleapis.com/runtime.v1alpha2.ExecRequest", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: ExecRequest): Int {
        var size = value.unknownFields.size
        if (value.container_id != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1,
            value.container_id)
        size += ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, value.cmd)
        if (value.tty != false) size += ProtoAdapter.BOOL.encodedSizeWithTag(3, value.tty)
        if (value.stdin != false) size += ProtoAdapter.BOOL.encodedSizeWithTag(4, value.stdin)
        if (value.stdout != false) size += ProtoAdapter.BOOL.encodedSizeWithTag(5, value.stdout)
        if (value.stderr != false) size += ProtoAdapter.BOOL.encodedSizeWithTag(6, value.stderr)
        return size
      }

      override fun encode(writer: ProtoWriter, value: ExecRequest) {
        if (value.container_id != "") ProtoAdapter.STRING.encodeWithTag(writer, 1,
            value.container_id)
        ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 2, value.cmd)
        if (value.tty != false) ProtoAdapter.BOOL.encodeWithTag(writer, 3, value.tty)
        if (value.stdin != false) ProtoAdapter.BOOL.encodeWithTag(writer, 4, value.stdin)
        if (value.stdout != false) ProtoAdapter.BOOL.encodeWithTag(writer, 5, value.stdout)
        if (value.stderr != false) ProtoAdapter.BOOL.encodeWithTag(writer, 6, value.stderr)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): ExecRequest {
        var container_id: String = ""
        val cmd = mutableListOf<String>()
        var tty: Boolean = false
        var stdin: Boolean = false
        var stdout: Boolean = false
        var stderr: Boolean = false
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> container_id = ProtoAdapter.STRING.decode(reader)
            2 -> cmd.add(ProtoAdapter.STRING.decode(reader))
            3 -> tty = ProtoAdapter.BOOL.decode(reader)
            4 -> stdin = ProtoAdapter.BOOL.decode(reader)
            5 -> stdout = ProtoAdapter.BOOL.decode(reader)
            6 -> stderr = ProtoAdapter.BOOL.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return ExecRequest(
          container_id = container_id,
          cmd = cmd,
          tty = tty,
          stdin = stdin,
          stdout = stdout,
          stderr = stderr,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: ExecRequest): ExecRequest = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
