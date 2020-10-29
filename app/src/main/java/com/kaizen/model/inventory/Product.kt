package com.kaizen.model.inventory

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("amount") val amount: Int
) {
    @SerializedName("presentation")
    lateinit var presentation: String

    @SerializedName("price")
    var price: Float = 0.0F

    @SerializedName("description")
    lateinit var description: String

    @SerializedName("applicationMonths")
    var applicationMonths: Int = 0

    @SerializedName("dataSheet")
    lateinit var dataSheet: String

    @SerializedName("healthRegister")
    lateinit var healthRegister: String

    @SerializedName("safetySheet")
    lateinit var safetySheet: String

    @SerializedName("emergencyCard")
    lateinit var emergencyCard: String
}
