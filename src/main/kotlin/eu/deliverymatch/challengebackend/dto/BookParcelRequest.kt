package eu.deliverymatch.challengebackend.dto

import eu.deliverymatch.challengebackend.common.Address
import eu.deliverymatch.challengebackend.common.Dimension
import java.time.LocalDate

data class BookParcelRequest(
    val name: String,
    val deliveryDate: LocalDate,
    val deliveryAddress: Address,
    val weight: Double,
    val dimension: Dimension
)
