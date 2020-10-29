package com.kaizen.model.applicationuser

import com.google.gson.annotations.SerializedName

data class ResetPasswordModel(
    @SerializedName("token") val token: String,
    @SerializedName("newPassword") val newPassword: String
)
