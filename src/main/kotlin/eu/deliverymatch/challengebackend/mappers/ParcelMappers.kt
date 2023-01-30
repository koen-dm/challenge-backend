package eu.deliverymatch.challengebackend.mappers

import eu.deliverymatch.challengebackend.common.Status
import eu.deliverymatch.challengebackend.dto.BookParcelRequest
import eu.deliverymatch.challengebackend.dto.BookParcelResponse
import eu.deliverymatch.challengebackend.model.Parcel
import java.util.*

fun BookParcelRequest.toModel() = Parcel(
    name = name,
    deliveryDate = deliveryDate,
    deliveryAddress = deliveryAddress,
    dimension = dimension,
    weight = weight,
    trackingNumber = UUID.randomUUID(),
    status = Status.BOOKED
)

fun Parcel.toBookedResponse() = BookParcelResponse(this.trackingNumber)