package eu.deliverymatch.challengebackend.services

import eu.deliverymatch.challengebackend.model.Parcel
import eu.deliverymatch.challengebackend.repositories.ParcelRepository
import org.springframework.stereotype.Service

@Service
class ParcelService(private val parcelRepository: ParcelRepository) {
    fun bookParcel(parcel: Parcel): Parcel {
        return parcelRepository.save(parcel)
    }
}