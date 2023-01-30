package eu.deliverymatch.challengebackend.model

import eu.deliverymatch.challengebackend.common.Address
import eu.deliverymatch.challengebackend.common.Dimension
import eu.deliverymatch.challengebackend.common.Status
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
    val trackingNumber: UUID,
    val status: Status,
) {
    fun toDelivered(): Parcel = Parcel(
        id = this.id,
        name = this.name,
        deliveryDate = this.deliveryDate,
        deliveryAddress = this.deliveryAddress,
        dimension = this.dimension,
        weight = this.weight,
        trackingNumber = this.trackingNumber,
        status = Status.DELIVERED
    )
}