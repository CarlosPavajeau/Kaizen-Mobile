package com.kaizen.network.api

import com.kaizen.model.client.Client
import com.kaizen.network.ApiUrls.CLIENTS_API_URL
import retrofit2.Call
import retrofit2.http.*

interface ClientsAPI {
    @POST(CLIENTS_API_URL)
    fun saveClient(@Body client: Client): Call<Client>

    @GET(CLIENTS_API_URL)
    fun getClients(): Call<List<Client>>

    @GET("$CLIENTS_API_URL/{id}")
    fun getClient(@Path("id") id: String): Call<Client>

    @GET("$CLIENTS_API_URL/Requests")
    fun getClientRequests(): Call<List<Client>>

    @PUT("$CLIENTS_API_URL/{id}")
    fun updateClient(@Path("id") id: String, @Body client: Client): Call<Client>
}
