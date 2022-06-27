plugins {
  id("uk.gov.justice.hmpps.gradle-spring-boot") version "4.3.0-beta-1"
  kotlin("plugin.spring") version "1.7.0"
}

configurations {
  testImplementation { exclude(group = "org.junit.vintage") }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-webflux")
}

tasks {
  compileKotlin {
    kotlinOptions {
      jvmTarget = "18"
    }
  }
}
