package com.kaizen.network.api

import com.kaizen.model.inventory.Product
import com.kaizen.network.ApiUrls.PRODUCTS_API_URL
import retrofit2.Call
import retrofit2.http.*

interface ProductsAPI {
    @POST(PRODUCTS_API_URL)
    fun saveProduct(@Body product: Product): Call<Product>

    @GET(PRODUCTS_API_URL)
    fun getProducts(): Call<List<Product>>

    @GET("$PRODUCTS_API_URL/{code}")
    fun getProduct(@Path("code") code: String): Call<Product>

    @PUT("$PRODUCTS_API_URL/{code}")
    fun updateProduct(@Path("code") code: String, @Body product: Product): Call<Product>
}
