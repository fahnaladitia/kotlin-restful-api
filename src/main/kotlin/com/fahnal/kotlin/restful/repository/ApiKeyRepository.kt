package com.fahnal.kotlin.restful.repository

import com.fahnal.kotlin.restful.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

/***
 *
 * @since 09/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
interface ApiKeyRepository : JpaRepository<ApiKey, String> {
}