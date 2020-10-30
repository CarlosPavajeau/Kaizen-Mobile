package com.kaizen.network.service

import com.kaizen.model.activityschedule.Activity
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.api.ActivitiesAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ActivityService {
    private val activitiesApi = ApiServiceBuilder.buildApiService(ActivitiesAPI::class.java)

    fun saveActivity(activity: Activity, apiCallback: ApiCallback<Activity>) {
        activitiesApi.saveActivity(activity).enqueue(
            object : Callback<Activity> {
                override fun onResponse(call: Call<Activity>, response: Response<Activity>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Activity>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getActivities(apiCallback: ApiCallback<List<Activity>>) {
        activitiesApi.getActivities().enqueue(
            object : Callback<List<Activity>> {
                override fun onResponse(
                    call: Call<List<Activity>>,
                    response: Response<List<Activity>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<Activity>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getActivity(activityCode: Int, apiCallback: ApiCallback<Activity>) {
        activitiesApi.getActivity(activityCode).enqueue(
            object : Callback<Activity> {
                override fun onResponse(call: Call<Activity>, response: Response<Activity>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Activity>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getPendingEmployeeActivities(
        employeeId: String,
        date: Date,
        apiCallback: ApiCallback<List<Activity>>
    ) {
        activitiesApi.getPendingEmployeeActivities(employeeId, date).enqueue(
            object : Callback<List<Activity>> {
                override fun onResponse(
                    call: Call<List<Activity>>,
                    response: Response<List<Activity>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<Activity>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getPendingClientActivities(clientId: String, apiCallback: ApiCallback<List<Activity>>) {
        activitiesApi.getPendingClientActivities(clientId).enqueue(
            object : Callback<List<Activity>> {
                override fun onResponse(
                    call: Call<List<Activity>>,
                    response: Response<List<Activity>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<Activity>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun updateActivity(activity: Activity, apiCallback: ApiCallback<Activity>) {
        activitiesApi.updateActivity(activity.code, activity).enqueue(
            object : Callback<Activity> {
                override fun onResponse(call: Call<Activity>, response: Response<Activity>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Activity>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }
}
