package com.kaizen.model.workorder

import com.google.gson.annotations.SerializedName
import com.kaizen.model.activityschedule.Activity
import com.kaizen.model.employee.Employee
import java.io.Serializable
import java.util.*

data class WorkOrder(
    @SerializedName("arrivalTime") val arrivalTime: Date
) : Serializable {
    @SerializedName("code")
    var code: Int = 0

    @SerializedName("workOrderState")
    lateinit var workOrderState: WorkOrderState

    @SerializedName("departureTime")
    lateinit var departureTime: Date

    @SerializedName("observations")
    lateinit var observations: String

    @SerializedName("sectorId")
    var sectorId: Int = 0

    @SerializedName("executionDate")
    lateinit var executionDate: Date

    @SerializedName("validity")
    lateinit var validity: Date

    @SerializedName("clientSignature")
    lateinit var clientSignature: String

    @SerializedName("activityCode")
    var activityCode: Int = 0

    @SerializedName("employeeId")
    lateinit var employeeId: String

    @SerializedName("employee")
    lateinit var employee: Employee

    @SerializedName("activity")
    lateinit var activity: Activity

    @SerializedName("sector")
    lateinit var sector: Sector
}
