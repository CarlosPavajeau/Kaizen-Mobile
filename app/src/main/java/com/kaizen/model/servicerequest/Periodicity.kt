package com.kaizen.model.servicerequest

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Periodicity(
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: PeriodicityType
) : Serializable

val PERIODICITIES = arrayOf(
    Periodicity("Quincenal", PeriodicityType.Biweekly),
    Periodicity("Mensual", PeriodicityType.Monthly),
    Periodicity("BiMensual", PeriodicityType.BiMonthly),
    Periodicity("Trimestral", PeriodicityType.Trimester),
    Periodicity("Cuatrimestral", PeriodicityType.Quarter),
    Periodicity("Quinquemestral", PeriodicityType.FiveMonth),
    Periodicity("Semestral", PeriodicityType.Biannual),
    Periodicity("Anual", PeriodicityType.Annual),
    Periodicity("Casual", PeriodicityType.Casual),
)
