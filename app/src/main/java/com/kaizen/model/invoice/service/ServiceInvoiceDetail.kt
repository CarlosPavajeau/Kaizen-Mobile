package com.kaizen.model.invoice.service

import com.google.gson.annotations.SerializedName
import com.kaizen.model.service.Service

data class ServiceInvoiceDetail(
    @SerializedName("serviceCode") val serviceCode: String,
    @SerializedName("serviceName") val serviceName: String
) {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("detail")
    lateinit var detail: Service

    @SerializedName("total")
    var total: Float = 0.0f
}
