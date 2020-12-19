package com.kaizen.model.employee

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class EmployeeCharge(
    @SerializedName("id") val id: Int,
    @SerializedName("charge") val charge: String
) : Serializable
