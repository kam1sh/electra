import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.0.0"

    id("com.squareup.wire") version "3.3.0"
    application
}

group = "com.github.kam1sh"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
}

apply(plugin = "com.squareup.wire")

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.kohlschutter.junixsocket:junixsocket-core:2.3.2")
    implementation("net.java.dev.jna:jna-platform:5.5.0")

    implementation("com.squareup.wire:wire-runtime:3.3.0")
    implementation("com.squareup.wire:wire-grpc-client:3.3.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
}

wire {
    kotlin {
        out = "src/main/kotlin"
        rpcRole = "client"
    }
}

application {
    mainClassName = "com.github.kam1sh.electra.AppKt"
}