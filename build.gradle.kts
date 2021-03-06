import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21"

    application
    id("com.github.johnrengelman.shadow") version "6.1.0"

    id("com.github.ben-manes.versions") version "0.36.0"
    id("se.patrikerdes.use-latest-versions") version "0.2.15"
}

group = "xerus"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.xerus2000.util", "kotlin", "master-SNAPSHOT")

    implementation("io.github.microutils", "kotlin-logging-jvm" , "2.0.4")
    testImplementation("org.slf4j", "slf4j-simple", "1.7.30")

    testImplementation("io.kotlintest", "kotlintest-runner-junit5", "3.4.2")
}


tasks {
    shadowJar {
        archiveClassifier.set(null as String?)
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    withType<Test> {
        useJUnitPlatform()
    }
}