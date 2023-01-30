package eu.deliverymatch.challengebackend.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import java.util.UUID


class ParcelNotFoundException(trackingNumber: UUID) : ResponseStatusException(HttpStatus.NOT_FOUND, "Parcel with tracking number $trackingNumber does not exist")