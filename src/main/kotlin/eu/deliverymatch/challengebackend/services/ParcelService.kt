package eu.deliverymatch.challengebackend.services

import eu.deliverymatch.challengebackend.exceptions.ParcelNotFoundException
import eu.deliverymatch.challengebackend.model.Parcel
import eu.deliverymatch.challengebackend.repositories.ParcelRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class ParcelService(private val parcelRepository: ParcelRepository) {
    fun bookParcel(parcel: Parcel): Parcel {
        return parcelRepository.save(parcel)
    }

    fun getByTrackingNumber(trackingNumber: UUID): Parcel {
        val parcel = parcelRepository.findByTrackingNumber(trackingNumber)
            ?: throw ParcelNotFoundException(trackingNumber)

        if (parcel.deliveryDate.isBefore(LocalDate.now())) {
            return updateToDelivered(parcel)
        }

        return parcel
    }

    private fun updateToDelivered(parcel: Parcel): Parcel {
        return parcelRepository.save(parcel.toDelivered())
    }
}