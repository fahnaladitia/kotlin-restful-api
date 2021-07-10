package com.fahnal.kotlin.restful.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/***
 *
 * @since 09/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
@Entity
@Table(name = "api_keys")
data class ApiKey(

    @Id
    val id: String
)