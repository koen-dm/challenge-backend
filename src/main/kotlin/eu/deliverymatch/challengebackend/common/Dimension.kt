package eu.deliverymatch.challengebackend.common

import jakarta.persistence.Access
import jakarta.persistence.AccessType
import jakarta.persistence.Embeddable

@Embeddable
data class Dimension(
    @Access(AccessType.FIELD)
    val height: Double,
    val width: Double,
    val length: Double
)