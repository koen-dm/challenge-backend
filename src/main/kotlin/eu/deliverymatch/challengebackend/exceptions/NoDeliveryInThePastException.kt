package eu.deliverymatch.challengebackend.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class NoDeliveryInThePastException : ResponseStatusException(HttpStatus.BAD_REQUEST, "It is not possible to book a parcel with a delivery date in the past") {
}