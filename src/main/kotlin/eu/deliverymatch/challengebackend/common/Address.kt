package eu.deliverymatch.challengebackend.common

import jakarta.persistence.Access
import jakarta.persistence.AccessType
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    @Access(AccessType.FIELD)
    val street: String,
    val houseNumber: Int,
    val houseNumberExtension: String?,
    val city: String,
    val postcode: String,
    val country: String,
)
