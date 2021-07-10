package com.fahnal.kotlin.restful.controller

import com.fahnal.kotlin.restful.model.*
import com.fahnal.kotlin.restful.service.ProductService
import org.springframework.web.bind.annotation.*

/***
 *
 * @since 08/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/products/{id_product}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("id_product") id: String): WebResponse<ProductResponse> {
        val productResponse = productService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun listProduct(
        @RequestParam("page", defaultValue = "0") page: Int,
        @RequestParam("size", defaultValue = "10") size: Int
    ): WebResponse<List<ProductResponse>> {
        val request = ListProductRequest(page,size)
        val response = productService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @PutMapping(
        value = ["/api/products/{id_product}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(
        @PathVariable("id_product") id: String,
        @RequestBody body: UpdateProductRequest
    ): WebResponse<ProductResponse> {
        val productResponse = productService.update(id, body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @DeleteMapping(
        value = ["/api/products/{id_product}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("id_product") id: String): WebResponse<String> {
        val productResponse = productService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }
}