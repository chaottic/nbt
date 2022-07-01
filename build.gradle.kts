plugins {
    `java-library`
    `maven-publish`
    id("io.freefair.lombok") version "6.5.0.2"
}

group = "com.chaottic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.chaottic"
            artifactId = "nbt"
            version = "1.0-SNAPSHOT"

            from(components["java"])
        }
    }
    repositories {
        maven {
            url = uri("https://maven.chaottic.com/repository/maven-snapshots/")
            credentials {
                val mavenUsername: String by project
                val mavenPassword: String by project
                username = mavenUsername
                password = mavenPassword
            }
        }
    }
}