package com.kaizen.network.api

import com.kaizen.model.activityschedule.Activity
import retrofit2.Call
import retrofit2.http.*
import java.util.*

private const val ACTIVITIES_API_URL = "api/Activities"

interface ActivitiesAPI {
    @Headers("Content-Type: application/json")
    @POST(ACTIVITIES_API_URL)
    fun saveActivity(@Body activity: Activity): Call<Activity>

    @Headers("Content-Type: application/json")
    @GET(ACTIVITIES_API_URL)
    fun getActivities(): Call<List<Activity>>

    @Headers("Content-Type: application/json")
    @GET("$ACTIVITIES_API_URL/{code}")
    fun getActivity(@Path("code") activityCode: Int): Call<Activity>

    @Headers("Content-Type: application/json")
    @GET("$ACTIVITIES_API_URL/EmployeeActivities/{employeeId}")
    fun getPendingEmployeeActivities(
        @Path("employeeId") employeeId: String,
        @Query("date") date: Date
    ): Call<List<Activity>>

    @Headers("Content-Type: application/json")
    @GET("$ACTIVITIES_API_URL/ClientActivities/{clientId}")
    fun getPendingClientActivities(@Path("clientId") clientId: String): Call<List<Activity>>

    @Headers("Content-Type: application/json")
    @PUT("$ACTIVITIES_API_URL/{activityCode}")
    fun updateActivity(
        @Path("activityCode") activityCode: Int,
        @Body activity: Activity
    ): Call<Activity>
}
