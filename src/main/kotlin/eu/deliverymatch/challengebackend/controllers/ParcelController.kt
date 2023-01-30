package eu.deliverymatch.challengebackend.controllers

import eu.deliverymatch.challengebackend.dto.BookParcelRequest
import eu.deliverymatch.challengebackend.dto.BookParcelResponse
import eu.deliverymatch.challengebackend.mappers.toBookedResponse
import eu.deliverymatch.challengebackend.mappers.toModel
import eu.deliverymatch.challengebackend.model.Parcel
import eu.deliverymatch.challengebackend.services.ParcelService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RequestMapping("/parcels")
@RestController
class ParcelController(private val parcelService: ParcelService) {
    @PostMapping
    fun bookParcel(@Valid @RequestBody createParcelRequest: BookParcelRequest): BookParcelResponse {
        val bookedParcel = parcelService.bookParcel(createParcelRequest.toModel())
        return bookedParcel.toBookedResponse()
    }

    @GetMapping("{tracking-number}")
    fun getTrackingInfo(@PathVariable("tracking-number") trackingNumber: UUID): Parcel {
        return parcelService.getByTrackingNumber(trackingNumber)
    }
}