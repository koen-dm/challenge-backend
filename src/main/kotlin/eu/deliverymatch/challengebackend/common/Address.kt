package eu.deliverymatch.challengebackend.common

import jakarta.persistence.Access
import jakarta.persistence.AccessType
import jakarta.persistence.Embeddable
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Embeddable
data class Address(
    @Access(AccessType.FIELD)
    @field:NotBlank
    val street: String,
    @field:Min(0)
    val houseNumber: Int,
    val houseNumberExtension: String?,
    @field:NotBlank
    val city: String,
    @field:NotBlank
    val postcode: String,
    @field:NotBlank
    @field:Size(min = 2, max = 2, message = "Please use ISO-2 format for country")
    val country: String,
)
