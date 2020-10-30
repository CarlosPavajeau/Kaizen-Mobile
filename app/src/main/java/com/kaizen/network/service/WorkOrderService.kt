package com.kaizen.network.service

import com.kaizen.model.workorder.Sector
import com.kaizen.model.workorder.WorkOrder
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.WorkOrdersAPI

class WorkOrderService {
    private val workOrderApi = ApiServiceBuilder.buildApiService(WorkOrdersAPI::class.java)

    fun saveWorkOrder(workOrder: WorkOrder, apiCallback: ApiCallback<WorkOrder>) {
        workOrderApi.saveWorkOrder(workOrder).enqueue(Callback(apiCallback))
    }

    fun getWorkOrders(apiCallback: ApiCallback<List<WorkOrder>>) {
        workOrderApi.getWorkOrders().enqueue(Callback(apiCallback))
    }

    fun getSectors(apiCallback: ApiCallback<List<Sector>>) {
        workOrderApi.getSectors().enqueue(Callback(apiCallback))
    }

    fun getWorkOrder(code: Int, apiCallback: ApiCallback<WorkOrder>) {
        workOrderApi.getWorkOrder(code).enqueue(Callback(apiCallback))
    }

    fun getWorkOrderOfActivity(activityCode: Int, apiCallback: ApiCallback<WorkOrder>) {
        workOrderApi.getWorkOrderOfActivity(activityCode).enqueue(Callback(apiCallback))
    }

    fun updateWorkOrder(workOrder: WorkOrder, apiCallback: ApiCallback<WorkOrder>) {
        workOrderApi.updateWorkOrder(workOrder.code, workOrder).enqueue(Callback(apiCallback))
    }
}
