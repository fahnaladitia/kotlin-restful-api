package com.fahnal.kotlin.restful.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Id

/***
 *
 * @since 08/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
data class ProductResponse(
    val id: String,
    val name: String,
    val price: Long,
    val quantity: Int,
    val createAt: Long,
    val updateAt: Long?
)