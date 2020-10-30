package com.kaizen.network.api

import com.kaizen.model.workorder.Sector
import com.kaizen.model.workorder.WorkOrder
import retrofit2.Call
import retrofit2.http.*

private const val WORK_ORDERS_API_URL = "api/WorkOrders"

interface WorkOrdersAPI {
    @Headers("Content-Type: application/json")
    @POST(WORK_ORDERS_API_URL)
    fun saveWorkOrder(@Body workOrder: WorkOrder): Call<WorkOrder>

    @Headers("Content-Type: application/json")
    @GET(WORK_ORDERS_API_URL)
    fun getWorkOrders(): Call<List<WorkOrder>>

    @Headers("Content-Type: application/json")
    @GET("$WORK_ORDERS_API_URL/Sectors")
    fun getSectors(): Call<List<Sector>>

    @Headers("Content-Type: application/json")
    @GET("$WORK_ORDERS_API_URL/{code}")
    fun getWorkOrder(@Path("code") code: Int): Call<WorkOrder>

    @Headers("Content-Type: application/json")
    @GET("$WORK_ORDERS_API_URL/ActivityWorkOrder/{activityCode}")
    fun getWorkOrderOfActivity(@Path("activityCode") activityCode: Int): Call<WorkOrder>

    @Headers("Content-Type: application/json")
    @PUT("$WORK_ORDERS_API_URL/{code}")
    fun updateWorkOrder(@Path("code") code: Int, @Body workOrder: WorkOrder): Call<WorkOrder>
}
