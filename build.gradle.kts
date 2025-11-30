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
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")

    // OBLIGATORIO para evitar errores de filtros y rutas
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Opcional, pero recomendado para health checks en microservicios
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
}

tasks.withType<Test> {
    useJUnitPlatform()
    enabled = false
}
