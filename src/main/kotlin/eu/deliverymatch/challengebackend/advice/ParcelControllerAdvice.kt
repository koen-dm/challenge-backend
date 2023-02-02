package eu.deliverymatch.challengebackend.advice

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.time.LocalDateTime

@ResponseBody
@ControllerAdvice
class ParcelControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun ratesNotFound(
        request: HttpServletRequest,
        response: HttpServletResponse,
        ex: MethodArgumentNotValidException,
    ): Map<String, Any> {
        val results = ex.bindingResult
        val errors = mutableListOf<Map<String, Any?>>()

        results.fieldErrors.forEach {
            errors.add(
                mapOf(
                    it.field to mapOf(
                        "error" to it.defaultMessage,
                        "rejectedValue" to it.rejectedValue
                    )
                )
            )
        }

        return mapOf(
            "timestamp" to LocalDateTime.now().toString(),
            "status" to HttpStatus.BAD_REQUEST.value(),
            "error" to HttpStatus.BAD_REQUEST.reasonPhrase,
            "message" to "Error validation request",
            "path" to request.contextPath,
            "errors" to errors,
        )
    }
}