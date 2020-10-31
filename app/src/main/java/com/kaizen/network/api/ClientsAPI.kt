package com.kaizen.network.api

import com.kaizen.model.client.Client
import retrofit2.Call
import retrofit2.http.*

private const val CLIENTS_API_URL = "api/Clients"

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
