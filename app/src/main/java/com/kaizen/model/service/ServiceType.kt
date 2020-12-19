package com.kaizen.model.service

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ServiceType(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
) : Serializable
