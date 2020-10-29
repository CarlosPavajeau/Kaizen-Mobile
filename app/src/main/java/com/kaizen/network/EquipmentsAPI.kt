package com.kaizen.network

import com.kaizen.model.Equipment
import retrofit2.Call
import retrofit2.http.*

private const val EQUIPMENTS_API_URL = "api/Equipments"

interface EquipmentsAPI {
    @Headers("Content-Type: application/json")
    @POST(EQUIPMENTS_API_URL)
    fun saveEquipment(@Body equipment: Equipment): Call<Equipment>

    @Headers("Content-Type: application/json")
    @GET(EQUIPMENTS_API_URL)
    fun getEquipments(): Call<List<Equipment>>

    @Headers("Content-Type: application/json")
    @GET("$EQUIPMENTS_API_URL/{code}")
    fun getEquipment(@Path("code") code: String): Call<Equipment>

    @Headers("Content-Type: application/json")
    @PUT("$EQUIPMENTS_API_URL/{code}")
    fun updateEquipment(@Path("code") code: String, @Body equipment: Equipment): Call<Equipment>
}
