package com.kaizen.network.service

import android.content.Context
import com.kaizen.model.activityschedule.Activity
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.ActivitiesAPI
import java.util.*

class ActivityService(context: Context) {
    private val activitiesApi =
        ApiServiceBuilder.buildApiService(ActivitiesAPI::class.java, context)

    fun saveActivity(activity: Activity, apiCallback: ApiCallback<Activity>) {
        activitiesApi.saveActivity(activity).enqueue(Callback(apiCallback))
    }

    fun getActivities(apiCallback: ApiCallback<List<Activity>>) {
        activitiesApi.getActivities().enqueue(Callback(apiCallback))
    }

    fun getActivity(activityCode: Int, apiCallback: ApiCallback<Activity>) {
        activitiesApi.getActivity(activityCode).enqueue(Callback(apiCallback))
    }

    fun getPendingEmployeeActivities(
        employeeId: String,
        date: Date,
        apiCallback: ApiCallback<List<Activity>>
    ) {
        activitiesApi.getPendingEmployeeActivities(employeeId, date).enqueue(Callback(apiCallback))
    }

    fun getPendingClientActivities(clientId: String, apiCallback: ApiCallback<List<Activity>>) {
        activitiesApi.getPendingClientActivities(clientId).enqueue(Callback(apiCallback))
    }

    fun getAppliedClientActivities(clientId: String, apiCallback: ApiCallback<List<Activity>>) {
        activitiesApi.getAppliedClientActivities(clientId).enqueue(Callback(apiCallback))
    }

    fun updateActivity(activity: Activity, apiCallback: ApiCallback<Activity>) {
        activitiesApi.updateActivity(activity.code, activity).enqueue(Callback(apiCallback))
    }
}
