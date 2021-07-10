package com.fahnal.kotlin.restful.config

import com.fahnal.kotlin.restful.entity.ApiKey
import com.fahnal.kotlin.restful.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

/***
 *
 * @since 09/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
@Component
class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {

    val apiKey = "SECRET"

    override fun run(args: ApplicationArguments?) {
        if(!apiKeyRepository.existsById(apiKey)) {
            val entity = ApiKey(id = apiKey)
            apiKeyRepository.save(entity)
        }
    }
}