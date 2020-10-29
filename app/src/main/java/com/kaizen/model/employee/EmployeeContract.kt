package com.kaizen.model.employee

import com.google.gson.annotations.SerializedName
import java.util.*

data class EmployeeContract(
    @SerializedName("contractCode") val contractCode: String,
    @SerializedName("startDate") val startDate: Date,
    @SerializedName("endDate") val endDate: Date
)
