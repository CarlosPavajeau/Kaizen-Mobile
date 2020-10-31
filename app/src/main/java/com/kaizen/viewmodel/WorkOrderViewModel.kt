package com.kaizen.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kaizen.model.workorder.Sector
import com.kaizen.model.workorder.WorkOrder
import com.kaizen.network.ApiCallback
import com.kaizen.network.service.WorkOrderService

class WorkOrderViewModel(context: Context) : ViewModel() {
    private val workOrderService = WorkOrderService(context)

    fun saveWorkOrder(workOrder: WorkOrder, apiCallback: ApiCallback<WorkOrder>) {
        workOrderService.saveWorkOrder(workOrder, apiCallback)
    }

    fun getWorkOrders(apiCallback: ApiCallback<List<WorkOrder>>) {
        workOrderService.getWorkOrders(apiCallback)
    }

    fun getSectors(apiCallback: ApiCallback<List<Sector>>) {
        workOrderService.getSectors(apiCallback)
    }

    fun getWorkOrder(code: Int, apiCallback: ApiCallback<WorkOrder>) {
        workOrderService.getWorkOrder(code, apiCallback)
    }

    fun getWorkOrderOfActivity(activityCode: Int, apiCallback: ApiCallback<WorkOrder>) {
        workOrderService.getWorkOrderOfActivity(activityCode, apiCallback)
    }

    fun updateWorkOrder(workOrder: WorkOrder, apiCallback: ApiCallback<WorkOrder>) {
        workOrderService.updateWorkOrder(workOrder, apiCallback)
    }
}
