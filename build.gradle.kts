plugins {
  id("uk.gov.justice.hmpps.gradle-spring-boot") version "4.5.0"
  kotlin("plugin.spring") version "1.7.10"
}

configurations {
  testImplementation { exclude(group = "org.junit.vintage") }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
  implementation("org.springframework.boot:spring-boot-starter-security")

  implementation("org.springframework.boot:spring-boot-starter-webflux")
}

tasks {
  compileKotlin {
    kotlinOptions {
      jvmTarget = "18"
    }
  }
}
