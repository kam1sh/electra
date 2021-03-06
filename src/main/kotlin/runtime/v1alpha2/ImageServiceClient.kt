// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.ImageService in io/k8s/cri_api.proto
package runtime.v1alpha2

import com.squareup.wire.GrpcCall
import com.squareup.wire.Service

/**
 * ImageService defines the public APIs for managing images.
 */
interface ImageServiceClient : Service {
  /**
   * ListImages lists existing images.
   */
  fun ListImages(): GrpcCall<ListImagesRequest, ListImagesResponse>

  /**
   * ImageStatus returns the status of the image. If the image is not
   * present, returns a response with ImageStatusResponse.Image set to
   * nil.
   */
  fun ImageStatus(): GrpcCall<ImageStatusRequest, ImageStatusResponse>

  /**
   * PullImage pulls an image with authentication config.
   */
  fun PullImage(): GrpcCall<PullImageRequest, PullImageResponse>

  /**
   * RemoveImage removes the image.
   * This call is idempotent, and must not return an error if the image has
   * already been removed.
   */
  fun RemoveImage(): GrpcCall<RemoveImageRequest, RemoveImageResponse>

  /**
   * ImageFSInfo returns information of the filesystem that is used to store images.
   */
  fun ImageFsInfo(): GrpcCall<ImageFsInfoRequest, ImageFsInfoResponse>
}
