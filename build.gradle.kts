plugins {
    id("java")
}

group = "org.carolina"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Jackson Core for basic JSON processing
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")

    // Jackson XML module for handling XML
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.2")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}

tasks.test {
    useJUnitPlatform()
}