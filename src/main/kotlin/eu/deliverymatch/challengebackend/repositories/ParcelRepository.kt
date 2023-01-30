package eu.deliverymatch.challengebackend.repositories

import eu.deliverymatch.challengebackend.model.Parcel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParcelRepository : JpaRepository<Parcel, Long>