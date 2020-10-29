package com.kaizen.network

import com.kaizen.model.client.Client
import retrofit2.Call
import retrofit2.http.*

private const val CLIENTS_API_URL = "api/Clients"

interface ClientsAPI {
    @Headers("Content-Type: application/json")
    @POST(CLIENTS_API_URL)
    fun saveClient(@Body client: Client): Call<Client>

    @Headers("Content-Type: application/json")
    @GET(CLIENTS_API_URL)
    fun getClients(): Call<List<Client>>

    @Headers("Content-Type: application/json")
    @GET("$CLIENTS_API_URL/{id}")
    fun getClient(@Path("id") id: String): Call<Client>

    @Headers("Content-Type: application/json")
    @GET("$CLIENTS_API_URL/Requests")
    fun getClientRequests(): Call<List<Client>>

    @Headers("Content-Type: application/json")
    @PUT("$CLIENTS_API_URL/{id}")
    fun updateClient(@Path("id") id: String, @Body client: Client): Call<Client>
}
