package com.kaizen.network.service

import android.content.Context
import com.kaizen.model.invoice.product.ProductInvoice
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.ProductInvoicesAPI

class ProductInvoiceService(context: Context) {
    private val productInvoiceApi =
        ApiServiceBuilder.buildApiService(ProductInvoicesAPI::class.java, context)

    fun saveProductInvoice(
        productInvoice: ProductInvoice,
        apiCallback: ApiCallback<ProductInvoice>
    ) {
        productInvoiceApi.saveProductInvoice(productInvoice).enqueue(Callback(apiCallback))
    }

    fun getProductInvoices(apiCallback: ApiCallback<List<ProductInvoice>>) {
        productInvoiceApi.getProductInvoices().enqueue(Callback(apiCallback))
    }

    fun getProductInvoice(id: Int, apiCallback: ApiCallback<ProductInvoice>) {
        productInvoiceApi.getProductInvoice(id).enqueue(Callback(apiCallback))
    }
}
