plugins {
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
}

group = "com.ip13"
version = "0.0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // spring boot starter
    implementation("org.springframework.boot:spring-boot-starter")

    // spring data jpa and postgres
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("org.flywaydb:flyway-core:9.22.3")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // reflection
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // web mvc
    implementation("org.springframework.boot:spring-boot-starter-web")

    // eureka
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    // security and jwt
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

    // for deserializing in web client
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.0")

    // open api
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // kafka
    implementation("org.springframework.kafka:spring-kafka:3.1.1")

    // loadbalancer
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")

    // kubernetes-discovery
    implementation("org.springframework.cloud:spring-cloud-starter-kubernetes-fabric8-all:3.1.0")
}

extra["springCloudVersion"] = "2023.0.0"

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.compileKotlin {
    kotlinOptions {
        // support for nullable types
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
    jvmToolchain(17)
}