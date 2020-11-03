package com.kaizen.network.api

import com.kaizen.model.service.Service
import com.kaizen.model.service.ServiceType
import com.kaizen.network.ApiUrls.SERVICES_API_URL
import retrofit2.Call
import retrofit2.http.*

interface ServicesAPI {
    @POST(SERVICES_API_URL)
    fun saveService(@Body service: Service): Call<Service>

    @GET(SERVICES_API_URL)
    fun getServices(): Call<List<Service>>

    @GET("$SERVICES_API_URL/ServiceTypes")
    fun getServiceTypes(): Call<List<ServiceType>>

    @GET("$SERVICES_API_URL/{code}")
    fun getService(@Path("code") code: String): Call<Service>

    @PUT("$SERVICES_API_URL/{code}")
    fun updateService(@Path("code") code: String, @Body service: Service): Call<Service>
}
