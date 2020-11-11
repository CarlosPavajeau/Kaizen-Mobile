package com.kaizen.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kaizen.model.invoice.product.ProductInvoice
import com.kaizen.network.ApiCallback
import com.kaizen.network.service.ProductInvoiceService

class ProductInvoiceViewModel(context: Context) : ViewModel() {
    private val productInvoiceService = ProductInvoiceService(context)

    fun saveProductInvoice(
        productInvoice: ProductInvoice,
        apiCallback: ApiCallback<ProductInvoice>
    ) {
        productInvoiceService.saveProductInvoice(productInvoice, apiCallback)
    }

    fun getProductInvoices(apiCallback: ApiCallback<List<ProductInvoice>>) {
        productInvoiceService.getProductInvoices(apiCallback)
    }

    fun getProductInvoice(id: Int, apiCallback: ApiCallback<ProductInvoice>) {
        productInvoiceService.getProductInvoice(id, apiCallback)
    }
}
