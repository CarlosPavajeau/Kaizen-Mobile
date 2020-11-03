package com.kaizen.model.invoice.product

import com.google.gson.annotations.SerializedName
import com.kaizen.model.inventory.Product

data class ProductInvoiceDetail(
    @SerializedName("productCode") val productCode: String,
    @SerializedName("productName") val productName: String
) {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("amount")
    var amount: Int = 0

    @SerializedName("detail")
    lateinit var detail: Product

    @SerializedName("total")
    val total: Float = 0.0f
}
