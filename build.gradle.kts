plugins {
  id("uk.gov.justice.hmpps.gradle-spring-boot") version "4.7.2-beta"
  kotlin("plugin.spring") version "1.7.22"
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
