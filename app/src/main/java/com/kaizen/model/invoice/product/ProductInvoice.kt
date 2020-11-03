package com.kaizen.model.invoice.product

import com.google.gson.annotations.SerializedName
import com.kaizen.model.client.Client
import com.kaizen.model.invoice.InvoiceState
import com.kaizen.model.invoice.PaymentMethod
import java.util.*

data class ProductInvoice(
    @SerializedName("state") val state: InvoiceState,
    @SerializedName("paymentMethod") val paymentMethod: PaymentMethod
) {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("generationDate ")
    lateinit var generationDate: Date

    @SerializedName("client")
    lateinit var client: Client

    @SerializedName("productInvoiceDetails")
    lateinit var productInvoiceDetails: ArrayList<ProductInvoiceDetail>

    @SerializedName("iva")
    var iva: Float = 0.0f

    @SerializedName("subTotal")
    var subTotal: Float = 0.0f

    @SerializedName("total")
    var total: Float = 0.0f
}
