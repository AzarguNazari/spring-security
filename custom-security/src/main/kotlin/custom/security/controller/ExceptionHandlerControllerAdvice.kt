package custom.security.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.*

@ControllerAdvice
class ExceptionHandlerControllerAdvice {
    @ExceptionHandler(NoSuchElementException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNoSuchElementException(e: NoSuchElementException): String? {
        return e.message
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice::class.java)
    }
}