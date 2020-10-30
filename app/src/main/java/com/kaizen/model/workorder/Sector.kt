package com.kaizen.model.workorder

import com.google.gson.annotations.SerializedName

data class Sector(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)
