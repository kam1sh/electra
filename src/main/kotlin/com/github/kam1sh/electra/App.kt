package com.github.kam1sh.electra

import org.newsclub.net.unix.AFUNIXSocket
import org.newsclub.net.unix.AFUNIXSocketAddress
import java.io.File

fun main() {
    val crioSockFile = File("/run/crio/crio.sock")
    val crioSocket = AFUNIXSocket.newInstance()
    crioSocket.connect(AFUNIXSocketAddress(crioSockFile))
}