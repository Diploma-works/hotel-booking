package com.ip13.main.exceptionHandling

import com.ip13.main.exceptionHandling.dto.CommonResponse
import com.ip13.main.exceptionHandling.exception.CommonException
import com.ip13.main.exceptionHandling.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@ControllerAdvice
class CommonControllerAdvice {
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<CommonResponse> {
        val message = "${LocalDateTime.now()}: $ex.message"
        return ResponseEntity(CommonResponse(message), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(ResponseStatusException::class)
    fun handleResponseStatusException(ex: ResponseStatusException): ResponseEntity<CommonResponse> {
        return ResponseEntity(CommonResponse(message = ex.message), ex.statusCode)
    }

    @ExceptionHandler(CommonException::class)
    fun handleCommonException(ex: CommonException): ResponseEntity<CommonResponse> {
        return ResponseEntity(CommonResponse(message = ex.toString()), ex.httpStatusCode)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<CommonResponse> {
        val message = "Looks like you entered invalid data.\n${ex.message}"
        return ResponseEntity(CommonResponse(message), HttpStatus.BAD_REQUEST)
    }
}