package com.fahnal.kotlin.restful.auth


import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/***
 *
 * @since 09/07/2021
 * @project kotlin-restful-api
 * @author Pahnal Aditia
 * */
@Component
class ApiKeyConfiguration(val apikeyInterceptor: ApikeyInterceptor) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        super.addInterceptors(registry)

        registry.addWebRequestInterceptor(apikeyInterceptor)
    }

}