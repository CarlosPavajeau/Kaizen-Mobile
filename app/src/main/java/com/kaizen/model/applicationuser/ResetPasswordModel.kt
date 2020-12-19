package com.kaizen.model.applicationuser

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResetPasswordModel(
    @SerializedName("token") val token: String,
    @SerializedName("newPassword") val newPassword: String
) : Serializable
