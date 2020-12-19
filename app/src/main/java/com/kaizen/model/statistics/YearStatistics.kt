package com.kaizen.model.statistics

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class YearStatistics(
    @SerializedName("id") val id: Int,
    @SerializedName("year") val year: Int
) : Serializable {
    @SerializedName("appliedActivities")
    var appliedActivities: Int = 0

    @SerializedName("clientsVisited")
    var clientsVisited: Int = 0

    @SerializedName("clientsRegistered")
    var clientsRegistered: Int = 0

    @SerializedName("profits")
    var profits: Float = 0.0f

    @SerializedName("monthStatistics")
    lateinit var monthStatistics: List<MonthStatistics>
}
