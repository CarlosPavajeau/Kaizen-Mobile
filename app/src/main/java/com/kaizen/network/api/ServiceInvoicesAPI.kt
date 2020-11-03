package com.kaizen.network.api

import com.kaizen.model.invoice.service.ServiceInvoice
import com.kaizen.network.ApiUrls.SERVICE_INVOICES_API_URL
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ServiceInvoicesAPI {
    @GET(SERVICE_INVOICES_API_URL)
    fun getServiceInvoices(): Call<List<ServiceInvoice>>

    @GET("$SERVICE_INVOICES_API_URL/ClientInvoices/{clientId}")
    fun getClientServiceInvoices(@Path("clientId") clientId: String): Call<List<ServiceInvoice>>

    @GET("$SERVICE_INVOICES_API_URL/{id}")
    fun getServiceInvoice(@Path("id") id: Int): Call<ServiceInvoice>

    @PUT("$SERVICE_INVOICES_API_URL/{id}")
    fun updateServiceInvoice(
        @Path("id") id: Int,
        @Body serviceInvoice: ServiceInvoice
    ): Call<ServiceInvoice>
}
