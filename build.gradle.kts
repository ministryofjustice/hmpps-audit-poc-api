plugins {
  id("uk.gov.justice.hmpps.gradle-spring-boot") version "5.2.1"
  kotlin("plugin.spring") version "1.8.22"
}

configurations {
  testImplementation { exclude(group = "org.junit.vintage") }
}

repositories {
  maven { url = uri("https://repo.spring.io/milestone") }
  mavenCentral()
}
dependencies {
  implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("uk.gov.justice.service.hmpps:hmpps-sqs-spring-boot-starter:2.0.0")

  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

  implementation(platform("com.amazonaws:aws-java-sdk-bom:1.12.496"))
}

java {
  toolchain.languageVersion.set(JavaLanguageVersion.of(19))
}

tasks {
  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
      jvmTarget = "19"
    }
  }
}
