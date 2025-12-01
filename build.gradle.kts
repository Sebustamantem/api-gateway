plugins {
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
}

group = "com.gateway"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.4")
    }
}

dependencies {
    // Gateway
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")

    //OBLIGATORIO: para leer config-server
    implementation("org.springframework.cloud:spring-cloud-starter-config")

    // Webflux es requerido por Gateway
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // Actuator para debugging
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Opcional
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
}

tasks.withType<Test> {
    useJUnitPlatform()
    enabled = false
}
