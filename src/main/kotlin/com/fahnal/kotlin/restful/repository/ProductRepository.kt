package com.fahnal.kotlin.restful.repository

import com.fahnal.kotlin.restful.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

/***
 *
 * @since 08/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
interface ProductRepository: JpaRepository<Product, String> {

}