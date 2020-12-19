package com.kaizen.model.workorder

import com.google.gson.annotations.SerializedName
import java.io.Serializable

enum class WorkOrderState : Serializable {
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
