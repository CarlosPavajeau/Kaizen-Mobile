package com.kaizen.model.applicationuser

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApplicationUser(
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("role") val role: String
) : Serializable {
    @SerializedName("id")
    var id: String = ""
    @SerializedName("token")
    var token: String = ""
}
