package com.kaizen.network.service

import com.kaizen.model.inventory.Equipment
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.EquipmentsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EquipmentService {
    private val equipmentsAPI = ApiServiceBuilder.buildApiService(EquipmentsAPI::class.java)

    fun saveEquipment(equipment: Equipment, apiCallback: ApiCallback<Equipment>) {
        equipmentsAPI.saveEquipment(equipment).enqueue(
            object : Callback<Equipment> {
                override fun onResponse(call: Call<Equipment>, response: Response<Equipment>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Equipment>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getEquipments(apiCallback: ApiCallback<List<Equipment>>) {
        equipmentsAPI.getEquipments().enqueue(
            object : Callback<List<Equipment>> {
                override fun onResponse(
                    call: Call<List<Equipment>>,
                    response: Response<List<Equipment>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<Equipment>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getEquipment(code: String, apiCallback: ApiCallback<Equipment>) {
        equipmentsAPI.getEquipment(code).enqueue(
            object : Callback<Equipment> {
                override fun onResponse(call: Call<Equipment>, response: Response<Equipment>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Equipment>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun updateEquipment(equipment: Equipment, apiCallback: ApiCallback<Equipment>) {
        equipmentsAPI.updateEquipment(equipment.code, equipment).enqueue(
            object : Callback<Equipment> {
                override fun onResponse(call: Call<Equipment>, response: Response<Equipment>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Equipment>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }
}
