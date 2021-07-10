package com.fahnal.kotlin.restful.service.impl

import com.fahnal.kotlin.restful.entity.Product
import com.fahnal.kotlin.restful.error.NotFoundException
import com.fahnal.kotlin.restful.model.CreateProductRequest
import com.fahnal.kotlin.restful.model.ListProductRequest
import com.fahnal.kotlin.restful.model.ProductResponse
import com.fahnal.kotlin.restful.model.UpdateProductRequest
import com.fahnal.kotlin.restful.repository.ProductRepository
import com.fahnal.kotlin.restful.service.ProductService
import com.fahnal.kotlin.restful.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collector
import java.util.stream.Collectors

/***
 *
 * @since 08/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
) : ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)

        val product = Product(
            id = createProductRequest.id,
            name = createProductRequest.name,
            price = createProductRequest.price,
            quantity = createProductRequest.quantity,
            createAt = System.currentTimeMillis(),
            updateAt = null
        )
        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
        val product = findProductByIdOrThrowNotFound(id)
        return convertProductToProductResponse(product)

    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products: List<Product> = page.get().collect(Collectors.toList())
        return products.map { convertProductToProductResponse(it) }
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = findProductByIdOrThrowNotFound(id)
        validationUtil.validate(updateProductRequest)

        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updateAt = System.currentTimeMillis()
        }

        productRepository.save(product)
        return convertProductToProductResponse(product)
    }

    override fun delete(id: String) {
        val product = findProductByIdOrThrowNotFound(id)
        productRepository.delete(product)
    }

    private fun findProductByIdOrThrowNotFound(id: String): Product {
        return productRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse {
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createAt = product.createAt,
            updateAt = product.updateAt
        )
    }


}