plugins {
    kotlin("jvm") version "1.4.30"
}

group = "me.ddu0422"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("io.kotest:kotest-runner-junit5:4.4.1")
    testImplementation("io.kotest:kotest-assertions-core:4.4.1")
    testImplementation ("io.kotest:kotest-property:4.4.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}