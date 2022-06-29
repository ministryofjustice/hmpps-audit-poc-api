package uk.gov.justice.digital.hmpps.hmppsauditpocapi.resource

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test", produces = [MediaType.APPLICATION_JSON_VALUE])
class TestAuditPocResource {
  @GetMapping
  fun getTestDataNoRoles(): TestDto = TestDto()

  @PreAuthorize("hasRole('ROLE_TESTING')")
  @GetMapping("/with-role")
  fun getTestData(): TestDto = TestDto()

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  fun postTestDataNoRoles(@RequestBody insertTestData: TestDto): TestDto = insertTestData.copy(result = "posted", processed = true)

  @PreAuthorize("hasRole('ROLE_TESTING') and hasAuthority('SCOPE_write')")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/with-role")
  fun postTestData(
    @RequestBody insertTestData: TestDto
  ): TestDto = insertTestData.copy(result = "posted with role", processed = true)

  @PreAuthorize("hasAuthority('SCOPE_write')")
  @PutMapping
  fun putTestDataNoRoles(
    @RequestBody updateTestData: TestDto
  ): TestDto = updateTestData.copy(result = "put", processed = true)

  @PreAuthorize("hasRole('ROLE_TESTING') and hasAuthority('SCOPE_write')")
  @PutMapping("/with-role")
  fun putTestData(
    @RequestBody updateTestData: TestDto
  ): TestDto = updateTestData.copy(result = "put with role", processed = true)
}

data class TestDto(
  val name: String = "fred",
  val description: String = "Smith",
  val result: String = "success",
  val processed: Boolean = false,
)
