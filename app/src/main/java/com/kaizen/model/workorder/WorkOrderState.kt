package com.kaizen.model.workorder

import com.google.gson.annotations.SerializedName

enum class WorkOrderState {
    @SerializedName("0")
    Generated,

    @SerializedName("1")
    Confirmed,

    @SerializedName("2")
    Canceled,

    @SerializedName("3")
    Valid,

    @SerializedName("4")
    Expired
}
