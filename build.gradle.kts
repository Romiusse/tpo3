plugins {
    kotlin("jvm") version "1.9.21"
}

group = "itmo.tpo.lab3"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    implementation("org.seleniumhq.selenium:selenium-java:4.10.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}