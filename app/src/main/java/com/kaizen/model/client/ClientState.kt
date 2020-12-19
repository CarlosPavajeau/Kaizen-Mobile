package com.kaizen.model.client

import com.google.gson.annotations.SerializedName
import java.io.Serializable

enum class ClientState : Serializable {
    @SerializedName("0")
    Pending,

    @SerializedName("1")
    Accepted,

    @SerializedName("2")
    Rejected,

    @SerializedName("3")
    Active,

    @SerializedName("4")
    Casual,

    @SerializedName("5")
    Inactive
}
