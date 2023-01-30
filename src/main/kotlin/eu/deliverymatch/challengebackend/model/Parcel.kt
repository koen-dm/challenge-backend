package eu.deliverymatch.challengebackend.model

import eu.deliverymatch.challengebackend.common.Address
import eu.deliverymatch.challengebackend.common.Dimension
import jakarta.persistence.*
import java.time.LocalDate
import java.util.UUID

@Entity
class Parcel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,
    val name: String,
    val deliveryDate: LocalDate,
    @Embedded
    val deliveryAddress: Address,
    @Embedded
    val dimension: Dimension,
    val weight: Double,
    val trackingNumber: UUID
)