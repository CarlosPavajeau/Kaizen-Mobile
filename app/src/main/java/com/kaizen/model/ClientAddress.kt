package com.kaizen.model

import com.google.gson.annotations.SerializedName

data class ClientAddress(
    @SerializedName("city") val city: String,
    @SerializedName("neighborhood") val neighborhood: String,
    @SerializedName("street") val street: String
)
