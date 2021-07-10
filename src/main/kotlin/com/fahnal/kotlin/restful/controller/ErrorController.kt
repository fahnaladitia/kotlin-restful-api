package com.fahnal.kotlin.restful.controller

import com.fahnal.kotlin.restful.error.NotFoundException
import com.fahnal.kotlin.restful.error.UnauthorizedException
import com.fahnal.kotlin.restful.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

/***
 *
 * @since 08/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String> {
        return WebResponse(
            code = 404,
            status = "NOT FOUND",
            data = "Not Found"
        )
    }
    @ExceptionHandler(value = [UnauthorizedException::class])
    fun notFound(unauthorizedException: UnauthorizedException): WebResponse<String> {
        return WebResponse(
            code = 401,
            status = "UNAUTHORIZED",
            data = "Please put your X-Api-Key"
        )
    }

}