package com.kaizen.network.service

import android.content.Context
import com.kaizen.model.invoice.service.ServiceInvoice
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.ServiceInvoicesAPI

class ServiceInvoiceService(context: Context) {
    private val serviceInvoiceApi =
        ApiServiceBuilder.buildApiService(ServiceInvoicesAPI::class.java, context)

    fun getServiceInvoices(apiCallback: ApiCallback<List<ServiceInvoice>>) {
        serviceInvoiceApi.getServiceInvoices().enqueue(Callback(apiCallback))
    }

    fun getClientServiceInvoices(clientId: String, apiCallback: ApiCallback<List<ServiceInvoice>>) {
        serviceInvoiceApi.getClientServiceInvoices(clientId).enqueue(Callback(apiCallback))
    }

    fun getServiceInvoice(id: Int, apiCallback: ApiCallback<ServiceInvoice>) {
        serviceInvoiceApi.getServiceInvoice(id).enqueue(Callback(apiCallback))
    }

    fun updateServiceInvoice(
        serviceInvoice: ServiceInvoice,
        apiCallback: ApiCallback<ServiceInvoice>
    ) {
        serviceInvoiceApi.updateServiceInvoice(serviceInvoice.id, serviceInvoice)
            .enqueue(Callback(apiCallback))
    }
}
