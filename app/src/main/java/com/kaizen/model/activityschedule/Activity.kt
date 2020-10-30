package com.kaizen.model.activityschedule

import com.google.gson.annotations.SerializedName
import com.kaizen.model.client.Client
import com.kaizen.model.employee.Employee
import com.kaizen.model.service.Service
import com.kaizen.model.servicerequest.PeriodicityType
import java.util.*

data class Activity(
    @SerializedName("date") val date: Date
) {
    @SerializedName("code")
    var code: Int = 0

    @SerializedName("state")
    lateinit var state: ActivityState

    @SerializedName("clientId")
    lateinit var clientId: String

    @SerializedName("periodicity")
    lateinit var periodicity: PeriodicityType

    @SerializedName("employeeCodes")
    lateinit var employeeCodes: Array<String>

    @SerializedName("serviceCodes")
    lateinit var serviceCodes: Array<String>

    @SerializedName("employees")
    lateinit var employees: Array<Employee>

    @SerializedName("services")
    lateinit var services: Array<Service>

    @SerializedName("client")
    lateinit var client: Client
}
