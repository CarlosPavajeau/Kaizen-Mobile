package com.kaizen.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kaizen.model.inventory.Equipment
import com.kaizen.network.ApiCallback
import com.kaizen.network.service.EquipmentService

class EquipmentViewModel(context: Context) : ViewModel() {
    private val equipmentService = EquipmentService(context)

    fun saveEquipment(equipment: Equipment, apiCallback: ApiCallback<Equipment>) {
        equipmentService.saveEquipment(equipment, apiCallback)
    }

    fun getEquipments(apiCallback: ApiCallback<List<Equipment>>) {
        equipmentService.getEquipments(apiCallback)
    }

    fun getEquipment(code: String, apiCallback: ApiCallback<Equipment>) {
        equipmentService.getEquipment(code, apiCallback)
    }

    fun updateEquipment(equipment: Equipment, apiCallback: ApiCallback<Equipment>) {
        equipmentService.updateEquipment(equipment, apiCallback)
    }
}
