package com.kaizen.model

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("id") val id: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String
) {
    @SerializedName("secondName")
    lateinit var secondName: String

    @SerializedName("secondLastName")
    lateinit var secondLastName: String

    @SerializedName("userId")
    lateinit var userId: String

    @SerializedName("chargeId")
    var chargeId: Int = 0

    @SerializedName("contractCode")
    lateinit var contractCode: String

    @SerializedName("employeeCharge")
    lateinit var employeeCharge: EmployeeCharge

    @SerializedName("employeeContract")
    lateinit var employeeContract: EmployeeContract
}
