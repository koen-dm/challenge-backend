package eu.deliverymatch.challengebackend.repositories

import eu.deliverymatch.challengebackend.model.Parcel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ParcelRepository : JpaRepository<Parcel, Long> {
    fun findByTrackingNumber(trackingNumber: UUID): Parcel?
}