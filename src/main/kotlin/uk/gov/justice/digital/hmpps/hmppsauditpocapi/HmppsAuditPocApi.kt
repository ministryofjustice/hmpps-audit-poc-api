package uk.gov.justice.digital.hmpps.hmppsauditpocapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication()
class HmppsAuditPocApi

fun main(args: Array<String>) {
  runApplication<HmppsAuditPocApi>(*args)
}
