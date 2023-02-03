import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.7.10"
    id("com.github.johnrengelman.shadow") version "6.0.0"

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://packages.confluent.io/maven")
}

object Versions {
    const val kotest = "5.5.4"
}


dependencies {
    implementation("io.confluent.ksql:ksqldb-udf:7.3.0")
    implementation("org.apache.kafka:kafka_2.13:2.5.0")
    implementation("org.apache.kafka:connect-api:2.5.0")

    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5-jvm:${Versions.kotest}")
    testImplementation("io.kotest:kotest-assertions-core-jvm:${Versions.kotest}")
    testImplementation("io.kotest:kotest-property-jvm:${Versions.kotest}")
    testImplementation("io.kotest:kotest-framework-datatest-jvm:${Versions.kotest}")
}

apply(plugin = "com.github.johnrengelman.shadow")
apply(plugin = "java")

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<JavaCompile>().all {
    options.compilerArgs.plus("-parameters")
}

tasks.withType<ShadowJar> {
    archiveBaseName.set("Extract_ID")
    archiveClassifier.set("")
    destinationDirectory.set(file("extensions"))

}
