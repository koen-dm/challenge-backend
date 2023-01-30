package eu.deliverymatch.challengebackend

import org.springframework.web.bind.annotation.*
import java.util.UUID

@RequestMapping("/parcels")
@RestController
class ParcelController {
    @PostMapping
    fun bookParcel(): String {
        return "Hello World"
    }

    @GetMapping("{tracking-number}")
    fun getTrackingInfo(@PathVariable("tracking-number") trackingNumber: UUID): UUID {
        return trackingNumber
    }
}