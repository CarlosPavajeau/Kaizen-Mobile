package com.kaizen.model.employee

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Employee(
    @SerializedName("id") val id: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String
) : Serializable {
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
