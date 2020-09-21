package com.github.kam1sh.electra

import com.github.dockerjava.okhttp.UnixSocketFactory
import com.squareup.wire.GrpcClient
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Protocol
import runtime.v1alpha2.ListContainersRequest
import runtime.v1alpha2.RuntimeServiceClient
import java.time.Duration

fun main() {
    val factory = UnixSocketFactory("/run/crio/crio.sock")
    val httpClient = OkHttpClient().newBuilder()
        .readTimeout(Duration.ofMinutes(1))
        .writeTimeout(Duration.ofMinutes(1))
        .callTimeout(Duration.ofMinutes(1))
        .protocols(listOf(Protocol.H2_PRIOR_KNOWLEDGE))
        .socketFactory(factory)
        .dns(factory)
        .build()


    val grpcClient = GrpcClient.Builder()
        .client(httpClient)
        .baseUrl("http://localhost/")
        .build()

    val client = grpcClient.create(RuntimeServiceClient::class)
    runBlocking {
        val containers = client.ListContainers().execute(ListContainersRequest())
        println(containers)
    }
}
