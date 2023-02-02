package eu.deliverymatch.challengebackend.dto

import eu.deliverymatch.challengebackend.common.Address
import eu.deliverymatch.challengebackend.common.Dimension
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class BookParcelRequest(
    @field:NotBlank
    val name: String,
    @field:NotNull
    val deliveryDate: LocalDate,
    @field:Valid
    val deliveryAddress: Address,
    @field:Min(0)
    val weight: Double,
    @field:Valid
    val dimension: Dimension
)
