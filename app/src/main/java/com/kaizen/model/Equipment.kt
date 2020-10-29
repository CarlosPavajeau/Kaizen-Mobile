package com.kaizen.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Equipment(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
) {
    @SerializedName("maintenanceDate")
    lateinit var maintenanceDate: Date

    @SerializedName("description")
    lateinit var description: String

    @SerializedName("amount")
    var amount: Int = 0

    @SerializedName("price")
    var price: Float = 0.0F
}
