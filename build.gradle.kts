import org.gradle.api.JavaVersion.VERSION_11

buildscript {
    repositories {
        jcenter()
        mavenCentral()
        maven("https://repo.spring.io/milestone")
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.M4")
    }
}

javafx {
    modules("javafx.base", "javafx.fxml", "javafx.controls")
}


plugins {
    java
    checkstyle
    id("org.openjfx.javafxplugin") version "0.0.7"
}

apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}


repositories {
    jcenter()
    mavenCentral()
    maven("https://repo.spring.io/milestone")
}

checkstyle {
    toolVersion = "8.2"
}

dependencies {
    // Rx
    implementation("io.reactivex.rxjava2:rxjava:2.1.3")
    implementation("io.reactivex.rxjava2:rxjavafx:2.2.0")
    // https://mvnrepository.com/artifact/org.openjfx/javafx.base

    // Spring Boot libraries
    implementation("org.springframework.boot:spring-boot-starter") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    runtime("org.springframework.boot:spring-boot-devtools")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testfx:testfx-core:4.0.+")
    testImplementation("org.testfx:testfx-junit5:4.0.+")
}

java {
    group = "io.github.thiagogcm.javafxstarter"
    version = "1.0"

    sourceCompatibility = VERSION_11
    targetCompatibility = VERSION_11
}

tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "5.1.1"
    }
}
