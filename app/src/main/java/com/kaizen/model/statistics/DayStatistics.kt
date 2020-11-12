package com.kaizen.model.statistics

import com.google.gson.annotations.SerializedName
import java.util.*

data class DayStatistics(
    @SerializedName("id") val id: Int,
    @SerializedName("date") val date: Date
) {
    @SerializedName("appliedActivities")
    var appliedActivities: Int = 0

    @SerializedName("clientsVisited")
    var clientsVisited: Int = 0

    @SerializedName("clientsRegistered")
    var clientsRegistered: Int = 0

    @SerializedName("profits")
    var profits: Float = 0.0f
}
