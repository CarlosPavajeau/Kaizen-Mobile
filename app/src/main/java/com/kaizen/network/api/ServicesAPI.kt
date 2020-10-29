package com.kaizen.network.api

import com.kaizen.model.services.Service
import com.kaizen.model.services.ServiceType
import retrofit2.Call
import retrofit2.http.*

private const val SERVICES_API_URL = "api/Services"

interface ServicesAPI {
    @Headers("Content-Type: application/json")
    @POST(SERVICES_API_URL)
    fun saveService(@Body service: Service): Call<Service>

    @Headers("Content-Type: application/json")
    @GET(SERVICES_API_URL)
    fun getServices(): Call<List<Service>>

    @Headers("Content-Type: application/json")
    @GET("$SERVICES_API_URL/ServiceTypes")
    fun getServiceTypes(): Call<List<ServiceType>>

    @Headers("Content-Type: application/json")
    @GET("$SERVICES_API_URL/{code}")
    fun getService(@Path("code") code: String): Call<Service>

    @Headers("Content-Type: application/json")
    @PUT("$SERVICES_API_URL/{code}")
    fun updateService(@Path("code") code: String, @Body service: Service): Call<Service>
}
