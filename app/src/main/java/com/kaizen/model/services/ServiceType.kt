package com.kaizen.model.services

import com.google.gson.annotations.SerializedName

data class ServiceType(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)
