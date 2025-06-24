plugins {
  id("uk.gov.justice.hmpps.gradle-spring-boot") version "8.3.0"
  kotlin("plugin.spring") version "2.2.0"
}

configurations {
  testImplementation { exclude(group = "org.junit.vintage") }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("uk.gov.justice.service.hmpps:hmpps-sqs-spring-boot-starter:5.4.5")

  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.9")

  implementation(platform("com.amazonaws:aws-java-sdk-bom:1.12.787"))
}

kotlin {
  jvmToolchain(21)
}

tasks {
  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions.jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21
  }
}
