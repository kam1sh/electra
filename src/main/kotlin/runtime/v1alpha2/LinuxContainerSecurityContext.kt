// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.LinuxContainerSecurityContext in io/k8s/cri_api.proto
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

/**
 * LinuxContainerSecurityContext holds linux security configuration that will be applied to a
 * container.
 */
class LinuxContainerSecurityContext(
  /**
   * Capabilities to add or drop.
   */
  @field:WireField(
    tag = 1,
    adapter = "runtime.v1alpha2.Capability#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY
  )
  val capabilities: Capability? = null,
  /**
   * If set, run container in privileged mode.
   * Privileged mode is incompatible with the following options. If
   * privileged is set, the following features MAY have no effect:
   * 1. capabilities
   * 2. selinux_options
   * 4. seccomp
   * 5. apparmor
   *
   * Privileged mode implies the following specific options are applied:
   * 1. All capabilities are added.
   * 2. Sensitive paths, such as kernel module paths within sysfs, are not masked.
   * 3. Any sysfs and procfs mounts are mounted RW.
   * 4. Apparmor confinement is not applied.
   * 5. Seccomp restrictions are not applied.
   * 6. The device cgroup does not restrict access to any devices.
   * 7. All devices from the host's /dev are available within the container.
   * 8. SELinux restrictions are not applied (e.g. label=disabled).
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
    label = WireField.Label.OMIT_IDENTITY
  )
  val privileged: Boolean = false,
  /**
   * Configurations for the container's namespaces.
   * Only used if the container uses namespace for isolation.
   */
  @field:WireField(
    tag = 3,
    adapter = "runtime.v1alpha2.NamespaceOption#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "namespaceOptions"
  )
  val namespace_options: NamespaceOption? = null,
  /**
   * SELinux context to be optionally applied.
   */
  @field:WireField(
    tag = 4,
    adapter = "runtime.v1alpha2.SELinuxOption#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "selinuxOptions"
  )
  val selinux_options: SELinuxOption? = null,
  /**
   * UID to run the container process as. Only one of run_as_user and
   * run_as_username can be specified at a time.
   */
  @field:WireField(
    tag = 5,
    adapter = "runtime.v1alpha2.Int64Value#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "runAsUser"
  )
  val run_as_user: Int64Value? = null,
  /**
   * GID to run the container process as. run_as_group should only be specified
   * when run_as_user or run_as_username is specified; otherwise, the runtime
   * MUST error.
   */
  @field:WireField(
    tag = 12,
    adapter = "runtime.v1alpha2.Int64Value#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "runAsGroup"
  )
  val run_as_group: Int64Value? = null,
  /**
   * User name to run the container process as. If specified, the user MUST
   * exist in the container image (i.e. in the /etc/passwd inside the image),
   * and be resolved there by the runtime; otherwise, the runtime MUST error.
   */
  @field:WireField(
    tag = 6,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "runAsUsername"
  )
  val run_as_username: String = "",
  /**
   * If set, the root filesystem of the container is read-only.
   */
  @field:WireField(
    tag = 7,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "readonlyRootfs"
  )
  val readonly_rootfs: Boolean = false,
  supplemental_groups: List<Long> = emptyList(),
  /**
   * AppArmor profile for the container, candidate values are:
   * * runtime/default: equivalent to not specifying a profile.
   * * unconfined: no profiles are loaded
   * * localhost/<profile_name>: profile loaded on the node
   *    (localhost) by name. The possible profile names are detailed at
   *    http://wiki.apparmor.net/index.php/AppArmor_Core_Policy_Reference
   */
  @field:WireField(
    tag = 9,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "apparmorProfile"
  )
  val apparmor_profile: String = "",
  /**
   * Seccomp profile for the container, candidate values are:
   * * runtime/default: the default profile for the container runtime
   * * unconfined: unconfined profile, ie, no seccomp sandboxing
   * * localhost/<full-path-to-profile>: the profile installed on the node.
   *   <full-path-to-profile> is the full path of the profile.
   * Default: "", which is identical with unconfined.
   */
  @field:WireField(
    tag = 10,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "seccompProfilePath"
  )
  val seccomp_profile_path: String = "",
  /**
   * no_new_privs defines if the flag for no_new_privs should be set on the
   * container.
   */
  @field:WireField(
    tag = 11,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "noNewPrivs"
  )
  val no_new_privs: Boolean = false,
  masked_paths: List<String> = emptyList(),
  readonly_paths: List<String> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<LinuxContainerSecurityContext, Nothing>(ADAPTER, unknownFields) {
  /**
   * List of groups applied to the first process run in the container, in
   * addition to the container's primary GID.
   */
  @field:WireField(
    tag = 8,
    adapter = "com.squareup.wire.ProtoAdapter#INT64",
    label = WireField.Label.PACKED,
    jsonName = "supplementalGroups"
  )
  val supplemental_groups: List<Long> = immutableCopyOf("supplemental_groups", supplemental_groups)

  /**
   * masked_paths is a slice of paths that should be masked by the container
   * runtime, this can be passed directly to the OCI spec.
   */
  @field:WireField(
    tag = 13,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.REPEATED,
    jsonName = "maskedPaths"
  )
  val masked_paths: List<String> = immutableCopyOf("masked_paths", masked_paths)

  /**
   * readonly_paths is a slice of paths that should be set as readonly by the
   * container runtime, this can be passed directly to the OCI spec.
   */
  @field:WireField(
    tag = 14,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.REPEATED,
    jsonName = "readonlyPaths"
  )
  val readonly_paths: List<String> = immutableCopyOf("readonly_paths", readonly_paths)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is LinuxContainerSecurityContext) return false
    if (unknownFields != other.unknownFields) return false
    if (capabilities != other.capabilities) return false
    if (privileged != other.privileged) return false
    if (namespace_options != other.namespace_options) return false
    if (selinux_options != other.selinux_options) return false
    if (run_as_user != other.run_as_user) return false
    if (run_as_group != other.run_as_group) return false
    if (run_as_username != other.run_as_username) return false
    if (readonly_rootfs != other.readonly_rootfs) return false
    if (supplemental_groups != other.supplemental_groups) return false
    if (apparmor_profile != other.apparmor_profile) return false
    if (seccomp_profile_path != other.seccomp_profile_path) return false
    if (no_new_privs != other.no_new_privs) return false
    if (masked_paths != other.masked_paths) return false
    if (readonly_paths != other.readonly_paths) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + capabilities.hashCode()
      result = result * 37 + privileged.hashCode()
      result = result * 37 + namespace_options.hashCode()
      result = result * 37 + selinux_options.hashCode()
      result = result * 37 + run_as_user.hashCode()
      result = result * 37 + run_as_group.hashCode()
      result = result * 37 + run_as_username.hashCode()
      result = result * 37 + readonly_rootfs.hashCode()
      result = result * 37 + supplemental_groups.hashCode()
      result = result * 37 + apparmor_profile.hashCode()
      result = result * 37 + seccomp_profile_path.hashCode()
      result = result * 37 + no_new_privs.hashCode()
      result = result * 37 + masked_paths.hashCode()
      result = result * 37 + readonly_paths.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (capabilities != null) result += """capabilities=$capabilities"""
    result += """privileged=$privileged"""
    if (namespace_options != null) result += """namespace_options=$namespace_options"""
    if (selinux_options != null) result += """selinux_options=$selinux_options"""
    if (run_as_user != null) result += """run_as_user=$run_as_user"""
    if (run_as_group != null) result += """run_as_group=$run_as_group"""
    result += """run_as_username=${sanitize(run_as_username)}"""
    result += """readonly_rootfs=$readonly_rootfs"""
    if (supplemental_groups.isNotEmpty()) result += """supplemental_groups=$supplemental_groups"""
    result += """apparmor_profile=${sanitize(apparmor_profile)}"""
    result += """seccomp_profile_path=${sanitize(seccomp_profile_path)}"""
    result += """no_new_privs=$no_new_privs"""
    if (masked_paths.isNotEmpty()) result += """masked_paths=${sanitize(masked_paths)}"""
    if (readonly_paths.isNotEmpty()) result += """readonly_paths=${sanitize(readonly_paths)}"""
    return result.joinToString(prefix = "LinuxContainerSecurityContext{", separator = ", ", postfix
        = "}")
  }

  fun copy(
    capabilities: Capability? = this.capabilities,
    privileged: Boolean = this.privileged,
    namespace_options: NamespaceOption? = this.namespace_options,
    selinux_options: SELinuxOption? = this.selinux_options,
    run_as_user: Int64Value? = this.run_as_user,
    run_as_group: Int64Value? = this.run_as_group,
    run_as_username: String = this.run_as_username,
    readonly_rootfs: Boolean = this.readonly_rootfs,
    supplemental_groups: List<Long> = this.supplemental_groups,
    apparmor_profile: String = this.apparmor_profile,
    seccomp_profile_path: String = this.seccomp_profile_path,
    no_new_privs: Boolean = this.no_new_privs,
    masked_paths: List<String> = this.masked_paths,
    readonly_paths: List<String> = this.readonly_paths,
    unknownFields: ByteString = this.unknownFields
  ): LinuxContainerSecurityContext = LinuxContainerSecurityContext(capabilities, privileged,
      namespace_options, selinux_options, run_as_user, run_as_group, run_as_username,
      readonly_rootfs, supplemental_groups, apparmor_profile, seccomp_profile_path, no_new_privs,
      masked_paths, readonly_paths, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<LinuxContainerSecurityContext> = object :
        ProtoAdapter<LinuxContainerSecurityContext>(
      FieldEncoding.LENGTH_DELIMITED, 
      LinuxContainerSecurityContext::class, 
      "type.googleapis.com/runtime.v1alpha2.LinuxContainerSecurityContext", 
      PROTO_3, 
      null
    ) {
      override fun encodedSize(value: LinuxContainerSecurityContext): Int {
        var size = value.unknownFields.size
        if (value.capabilities != null) size += Capability.ADAPTER.encodedSizeWithTag(1,
            value.capabilities)
        if (value.privileged != false) size += ProtoAdapter.BOOL.encodedSizeWithTag(2,
            value.privileged)
        if (value.namespace_options != null) size += NamespaceOption.ADAPTER.encodedSizeWithTag(3,
            value.namespace_options)
        if (value.selinux_options != null) size += SELinuxOption.ADAPTER.encodedSizeWithTag(4,
            value.selinux_options)
        if (value.run_as_user != null) size += Int64Value.ADAPTER.encodedSizeWithTag(5,
            value.run_as_user)
        if (value.run_as_group != null) size += Int64Value.ADAPTER.encodedSizeWithTag(12,
            value.run_as_group)
        if (value.run_as_username != "") size += ProtoAdapter.STRING.encodedSizeWithTag(6,
            value.run_as_username)
        if (value.readonly_rootfs != false) size += ProtoAdapter.BOOL.encodedSizeWithTag(7,
            value.readonly_rootfs)
        size += ProtoAdapter.INT64.asPacked().encodedSizeWithTag(8, value.supplemental_groups)
        if (value.apparmor_profile != "") size += ProtoAdapter.STRING.encodedSizeWithTag(9,
            value.apparmor_profile)
        if (value.seccomp_profile_path != "") size += ProtoAdapter.STRING.encodedSizeWithTag(10,
            value.seccomp_profile_path)
        if (value.no_new_privs != false) size += ProtoAdapter.BOOL.encodedSizeWithTag(11,
            value.no_new_privs)
        size += ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(13, value.masked_paths)
        size += ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(14, value.readonly_paths)
        return size
      }

      override fun encode(writer: ProtoWriter, value: LinuxContainerSecurityContext) {
        if (value.capabilities != null) Capability.ADAPTER.encodeWithTag(writer, 1,
            value.capabilities)
        if (value.privileged != false) ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.privileged)
        if (value.namespace_options != null) NamespaceOption.ADAPTER.encodeWithTag(writer, 3,
            value.namespace_options)
        if (value.selinux_options != null) SELinuxOption.ADAPTER.encodeWithTag(writer, 4,
            value.selinux_options)
        if (value.run_as_user != null) Int64Value.ADAPTER.encodeWithTag(writer, 5,
            value.run_as_user)
        if (value.run_as_group != null) Int64Value.ADAPTER.encodeWithTag(writer, 12,
            value.run_as_group)
        if (value.run_as_username != "") ProtoAdapter.STRING.encodeWithTag(writer, 6,
            value.run_as_username)
        if (value.readonly_rootfs != false) ProtoAdapter.BOOL.encodeWithTag(writer, 7,
            value.readonly_rootfs)
        ProtoAdapter.INT64.asPacked().encodeWithTag(writer, 8, value.supplemental_groups)
        if (value.apparmor_profile != "") ProtoAdapter.STRING.encodeWithTag(writer, 9,
            value.apparmor_profile)
        if (value.seccomp_profile_path != "") ProtoAdapter.STRING.encodeWithTag(writer, 10,
            value.seccomp_profile_path)
        if (value.no_new_privs != false) ProtoAdapter.BOOL.encodeWithTag(writer, 11,
            value.no_new_privs)
        ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 13, value.masked_paths)
        ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 14, value.readonly_paths)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): LinuxContainerSecurityContext {
        var capabilities: Capability? = null
        var privileged: Boolean = false
        var namespace_options: NamespaceOption? = null
        var selinux_options: SELinuxOption? = null
        var run_as_user: Int64Value? = null
        var run_as_group: Int64Value? = null
        var run_as_username: String = ""
        var readonly_rootfs: Boolean = false
        val supplemental_groups = mutableListOf<Long>()
        var apparmor_profile: String = ""
        var seccomp_profile_path: String = ""
        var no_new_privs: Boolean = false
        val masked_paths = mutableListOf<String>()
        val readonly_paths = mutableListOf<String>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> capabilities = Capability.ADAPTER.decode(reader)
            2 -> privileged = ProtoAdapter.BOOL.decode(reader)
            3 -> namespace_options = NamespaceOption.ADAPTER.decode(reader)
            4 -> selinux_options = SELinuxOption.ADAPTER.decode(reader)
            5 -> run_as_user = Int64Value.ADAPTER.decode(reader)
            12 -> run_as_group = Int64Value.ADAPTER.decode(reader)
            6 -> run_as_username = ProtoAdapter.STRING.decode(reader)
            7 -> readonly_rootfs = ProtoAdapter.BOOL.decode(reader)
            8 -> supplemental_groups.add(ProtoAdapter.INT64.decode(reader))
            9 -> apparmor_profile = ProtoAdapter.STRING.decode(reader)
            10 -> seccomp_profile_path = ProtoAdapter.STRING.decode(reader)
            11 -> no_new_privs = ProtoAdapter.BOOL.decode(reader)
            13 -> masked_paths.add(ProtoAdapter.STRING.decode(reader))
            14 -> readonly_paths.add(ProtoAdapter.STRING.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return LinuxContainerSecurityContext(
          capabilities = capabilities,
          privileged = privileged,
          namespace_options = namespace_options,
          selinux_options = selinux_options,
          run_as_user = run_as_user,
          run_as_group = run_as_group,
          run_as_username = run_as_username,
          readonly_rootfs = readonly_rootfs,
          supplemental_groups = supplemental_groups,
          apparmor_profile = apparmor_profile,
          seccomp_profile_path = seccomp_profile_path,
          no_new_privs = no_new_privs,
          masked_paths = masked_paths,
          readonly_paths = readonly_paths,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: LinuxContainerSecurityContext): LinuxContainerSecurityContext =
          value.copy(
        capabilities = value.capabilities?.let(Capability.ADAPTER::redact),
        namespace_options = value.namespace_options?.let(NamespaceOption.ADAPTER::redact),
        selinux_options = value.selinux_options?.let(SELinuxOption.ADAPTER::redact),
        run_as_user = value.run_as_user?.let(Int64Value.ADAPTER::redact),
        run_as_group = value.run_as_group?.let(Int64Value.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
