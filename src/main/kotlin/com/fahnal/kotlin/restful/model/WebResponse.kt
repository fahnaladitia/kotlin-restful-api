package com.fahnal.kotlin.restful.model

/***
 *
 * @since 08/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
data class WebResponse<T>(
    val code: Int,
    val status: String,
    val data: T
)