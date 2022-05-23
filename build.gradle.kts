plugins {
  id("uk.gov.justice.hmpps.gradle-spring-boot") version "4.2.0-beta"
  kotlin("plugin.spring") version "1.6.21"
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
      jvmTarget = "17"
    }
  }
}
