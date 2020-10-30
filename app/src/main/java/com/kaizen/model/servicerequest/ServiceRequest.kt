package com.kaizen.model.servicerequest

import com.google.gson.annotations.SerializedName
import com.kaizen.model.client.Client
import com.kaizen.model.service.Service
import java.util.*

data class ServiceRequest(
    @SerializedName("code") val code: Int,
    @SerializedName("date") val date: Date
) {
    @SerializedName("clientId")
    lateinit var clientId: String

    @SerializedName("serviceCodes")
    lateinit var serviceCodes: Array<String>

    @SerializedName("state")
    lateinit var state: ServiceRequestState

    @SerializedName("periodicity")
    lateinit var periodicity: PeriodicityType

    @SerializedName("client")
    lateinit var client: Client

    @SerializedName("services")
    lateinit var services: Array<Service>
}
