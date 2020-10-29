package com.kaizen.model

import com.google.gson.annotations.SerializedName

data class ContactPerson(
    @SerializedName("name") val name: String,
    @SerializedName("phonenumber") val phonenumber: String
)
