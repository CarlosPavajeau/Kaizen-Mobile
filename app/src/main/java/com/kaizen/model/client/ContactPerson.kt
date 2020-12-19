package com.kaizen.model.client

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ContactPerson(
    @SerializedName("name") val name: String,
    @SerializedName("phonenumber") val phonenumber: String
) : Serializable
