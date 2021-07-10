package com.fahnal.kotlin.restful.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/***
 *
 * @since 08/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
@Entity
@Table(name = "products")
data class Product(
    @Id
    val id: String,
    @Column(name = "name")
    var name: String,
    @Column(name = "price")
    var price: Long,
    @Column(name = "quantity")
    var quantity: Int,
    @Column(name = "create_at")
    var createAt: Long,
    @Column(name = "update_at")
    var updateAt: Long?
)
