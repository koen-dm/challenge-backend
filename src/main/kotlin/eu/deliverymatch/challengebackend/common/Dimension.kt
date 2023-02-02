package eu.deliverymatch.challengebackend.common

import jakarta.persistence.Access
import jakarta.persistence.AccessType
import jakarta.persistence.Embeddable
import jakarta.validation.constraints.Min

@Embeddable
data class Dimension(
    @Access(AccessType.FIELD)
    @field:Min(0)
    val height: Double,
    @field:Min(0)
    val width: Double,
    @field:Min(0)
    val length: Double
)