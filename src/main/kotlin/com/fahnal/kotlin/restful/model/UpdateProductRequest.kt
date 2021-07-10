package com.fahnal.kotlin.restful.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/***
 *
 * @since 08/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
data class UpdateProductRequest(

    @field:NotBlank
    val name: String?,

    @field:NotNull
    @field:Min(value = 1)
    val price: Long?,

    @field:NotNull
    @field:Min(value = 0)
    val quantity: Int?
)
