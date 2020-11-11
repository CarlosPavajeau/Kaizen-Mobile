package com.kaizen.network.api

import com.kaizen.model.invoice.product.ProductInvoice
import com.kaizen.network.ApiUrls.PRODUCT_INVOICES_API_URL
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductInvoicesAPI {
    @POST(PRODUCT_INVOICES_API_URL)
    fun saveProductInvoice(@Body productInvoice: ProductInvoice): Call<ProductInvoice>

    @GET(PRODUCT_INVOICES_API_URL)
    fun getProductInvoices(): Call<List<ProductInvoice>>

    @GET("$PRODUCT_INVOICES_API_URL/{id}")
    fun getProductInvoice(@Path("id") id: Int): Call<ProductInvoice>
}
