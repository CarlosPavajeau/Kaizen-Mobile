package com.kaizen.models

import com.google.gson.annotations.SerializedName

data class ApplicationUser(
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("role") val role: String
) {
    @SerializedName("id") var id: String = ""
    @SerializedName("token") var token: String = ""
}
