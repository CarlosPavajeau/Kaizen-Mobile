package com.kaizen.model.servicerequest

import com.google.gson.annotations.SerializedName
import java.io.Serializable

enum class PeriodicityType : Serializable {
    @SerializedName("0")
    Biweekly,

    @SerializedName("1")
    Monthly,

    @SerializedName("2")
    BiMonthly,

    @SerializedName("3")
    Trimester,

    @SerializedName("4")
    Quarter,

    @SerializedName("5")
    FiveMonth,

    @SerializedName("6")
    Biannual,

    @SerializedName("7")
    Annual,

    @SerializedName("8")
    Casual
}
