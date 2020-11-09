package com.kaizen.model.activityschedule

import com.google.gson.annotations.SerializedName
import java.util.*

data class ActivityDay(
    @SerializedName("name") val name: String,
    @SerializedName("number") val number: Int
) {
    @SerializedName("isToday")
    var isToday: Boolean = false

    @SerializedName("date")
    lateinit var date: Date

    @SerializedName("activities")
    lateinit var activities: List<Activity>
}
