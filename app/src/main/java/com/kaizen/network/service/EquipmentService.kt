package com.kaizen.network.service

import com.kaizen.model.inventory.Equipment
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.EquipmentsAPI

class EquipmentService {
    private val equipmentsAPI = ApiServiceBuilder.buildApiService(EquipmentsAPI::class.java)

    fun saveEquipment(equipment: Equipment, apiCallback: ApiCallback<Equipment>) {
        equipmentsAPI.saveEquipment(equipment).enqueue(Callback(apiCallback))
    }

    fun getEquipments(apiCallback: ApiCallback<List<Equipment>>) {
        equipmentsAPI.getEquipments().enqueue(Callback(apiCallback))
    }

    fun getEquipment(code: String, apiCallback: ApiCallback<Equipment>) {
        equipmentsAPI.getEquipment(code).enqueue(Callback(apiCallback))
    }

    fun updateEquipment(equipment: Equipment, apiCallback: ApiCallback<Equipment>) {
        equipmentsAPI.updateEquipment(equipment.code, equipment).enqueue(Callback(apiCallback))
    }
}
