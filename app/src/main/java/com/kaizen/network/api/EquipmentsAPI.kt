package com.kaizen.network.api

import com.kaizen.model.inventory.Equipment
import com.kaizen.network.ApiUrls.EQUIPMENTS_API_URL
import retrofit2.Call
import retrofit2.http.*

interface EquipmentsAPI {
    @POST(EQUIPMENTS_API_URL)
    fun saveEquipment(@Body equipment: Equipment): Call<Equipment>

    @GET(EQUIPMENTS_API_URL)
    fun getEquipments(): Call<List<Equipment>>

    @GET("$EQUIPMENTS_API_URL/{code}")
    fun getEquipment(@Path("code") code: String): Call<Equipment>

    @PUT("$EQUIPMENTS_API_URL/{code}")
    fun updateEquipment(@Path("code") code: String, @Body equipment: Equipment): Call<Equipment>
}
