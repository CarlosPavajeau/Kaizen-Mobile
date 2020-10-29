package com.kaizen.model

import com.google.gson.annotations.SerializedName

class EmployeeCharge(
    @SerializedName("id") val id: Int,
    @SerializedName("charge") val charge: String
)
