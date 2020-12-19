package com.kaizen.model.activityschedule

import com.google.gson.annotations.SerializedName
import java.io.Serializable

enum class ActivityState : Serializable {
    @SerializedName("0")
    Pending,

    @SerializedName("1")
    Accepted,

    @SerializedName("2")
    Rejected,

    @SerializedName("3")
    PendingSuggestedDate,

    @SerializedName("4")
    Applied
}
