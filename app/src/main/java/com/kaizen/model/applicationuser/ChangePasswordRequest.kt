package com.kaizen.model.applicationuser

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ChangePasswordRequest(
    @SerializedName("oldPassword") val oldPassword: String,
    @SerializedName("newPassword") val newPassword: String
) : Serializable
