package com.fahnal.kotlin.restful.service

import com.fahnal.kotlin.restful.model.CreateProductRequest
import com.fahnal.kotlin.restful.model.ListProductRequest
import com.fahnal.kotlin.restful.model.ProductResponse
import com.fahnal.kotlin.restful.model.UpdateProductRequest

/***
 *
 * @since 08/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: String)

}