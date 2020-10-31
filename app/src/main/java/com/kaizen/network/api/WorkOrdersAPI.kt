package com.kaizen.network.api

import com.kaizen.model.workorder.Sector
import com.kaizen.model.workorder.WorkOrder
import retrofit2.Call
import retrofit2.http.*

private const val WORK_ORDERS_API_URL = "api/WorkOrders"

interface WorkOrdersAPI {
    @POST(WORK_ORDERS_API_URL)
    fun saveWorkOrder(@Body workOrder: WorkOrder): Call<WorkOrder>

    @GET(WORK_ORDERS_API_URL)
    fun getWorkOrders(): Call<List<WorkOrder>>

    @GET("$WORK_ORDERS_API_URL/Sectors")
    fun getSectors(): Call<List<Sector>>

    @GET("$WORK_ORDERS_API_URL/{code}")
    fun getWorkOrder(@Path("code") code: Int): Call<WorkOrder>

    @GET("$WORK_ORDERS_API_URL/ActivityWorkOrder/{activityCode}")
    fun getWorkOrderOfActivity(@Path("activityCode") activityCode: Int): Call<WorkOrder>

    @PUT("$WORK_ORDERS_API_URL/{code}")
    fun updateWorkOrder(@Path("code") code: Int, @Body workOrder: WorkOrder): Call<WorkOrder>
}
