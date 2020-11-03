package com.kaizen.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kaizen.model.invoice.service.ServiceInvoice
import com.kaizen.network.ApiCallback
import com.kaizen.network.service.ServiceInvoiceService

class ServiceInvoiceViewModel(context: Context) : ViewModel() {
    private val serviceInvoiceService = ServiceInvoiceService(context)

    fun getServiceInvoices(apiCallback: ApiCallback<List<ServiceInvoice>>) {
        serviceInvoiceService.getServiceInvoices(apiCallback)
    }

    fun getClientServiceInvoices(clientId: String, apiCallback: ApiCallback<List<ServiceInvoice>>) {
        serviceInvoiceService.getClientServiceInvoices(clientId, apiCallback)
    }

    fun getServiceInvoice(id: Int, apiCallback: ApiCallback<ServiceInvoice>) {
        serviceInvoiceService.getServiceInvoice(id, apiCallback)
    }

    fun updateServiceInvoice(
        serviceInvoice: ServiceInvoice,
        apiCallback: ApiCallback<ServiceInvoice>
    ) {
        serviceInvoiceService.updateServiceInvoice(serviceInvoice, apiCallback)
    }
}
