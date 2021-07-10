package com.fahnal.kotlin.restful.validation

import org.springframework.stereotype.Component
import javax.validation.ConstraintViolationException
import javax.validation.Validator

/***
 *
 * @since 08/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
@Component
class ValidationUtil(val validator: Validator) {

    fun validate(any: Any) {
        val result = validator.validate(any)

        if(result.size != 0) {
            throw ConstraintViolationException(result)
        }
    }
}