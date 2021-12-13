plugins {
  id("uk.gov.justice.hmpps.gradle-spring-boot") version "3.3.14"
  kotlin("plugin.spring") version "1.5.30"
}

configurations {
  testImplementation { exclude(group = "org.junit.vintage") }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
}

tasks {
  compileKotlin {
    kotlinOptions {
      jvmTarget = "16"
    }
  }
}
