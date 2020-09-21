// Code generated by Wire protocol buffer compiler, do not edit.
// Source: runtime.v1alpha2.ImageService in io/k8s/cri_api.proto
package runtime.v1alpha2

import com.squareup.wire.GrpcCall
import com.squareup.wire.GrpcClient
import com.squareup.wire.GrpcMethod

/**
 * ImageService defines the public APIs for managing images.
 */
class GrpcImageServiceClient(
  private val client: GrpcClient
) : ImageServiceClient {
  /**
   * ListImages lists existing images.
   */
  override fun ListImages(): GrpcCall<ListImagesRequest, ListImagesResponse> =
      client.newCall(GrpcMethod(
      path = "/runtime.v1alpha2.ImageService/ListImages",
      requestAdapter = ListImagesRequest.ADAPTER,
      responseAdapter = ListImagesResponse.ADAPTER
  ))

  /**
   * ImageStatus returns the status of the image. If the image is not
   * present, returns a response with ImageStatusResponse.Image set to
   * nil.
   */
  override fun ImageStatus(): GrpcCall<ImageStatusRequest, ImageStatusResponse> =
      client.newCall(GrpcMethod(
      path = "/runtime.v1alpha2.ImageService/ImageStatus",
      requestAdapter = ImageStatusRequest.ADAPTER,
      responseAdapter = ImageStatusResponse.ADAPTER
  ))

  /**
   * PullImage pulls an image with authentication config.
   */
  override fun PullImage(): GrpcCall<PullImageRequest, PullImageResponse> =
      client.newCall(GrpcMethod(
      path = "/runtime.v1alpha2.ImageService/PullImage",
      requestAdapter = PullImageRequest.ADAPTER,
      responseAdapter = PullImageResponse.ADAPTER
  ))

  /**
   * RemoveImage removes the image.
   * This call is idempotent, and must not return an error if the image has
   * already been removed.
   */
  override fun RemoveImage(): GrpcCall<RemoveImageRequest, RemoveImageResponse> =
      client.newCall(GrpcMethod(
      path = "/runtime.v1alpha2.ImageService/RemoveImage",
      requestAdapter = RemoveImageRequest.ADAPTER,
      responseAdapter = RemoveImageResponse.ADAPTER
  ))

  /**
   * ImageFSInfo returns information of the filesystem that is used to store images.
   */
  override fun ImageFsInfo(): GrpcCall<ImageFsInfoRequest, ImageFsInfoResponse> =
      client.newCall(GrpcMethod(
      path = "/runtime.v1alpha2.ImageService/ImageFsInfo",
      requestAdapter = ImageFsInfoRequest.ADAPTER,
      responseAdapter = ImageFsInfoResponse.ADAPTER
  ))
}
