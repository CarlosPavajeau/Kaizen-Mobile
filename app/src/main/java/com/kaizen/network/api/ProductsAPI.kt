package com.kaizen.network.api

import com.kaizen.model.inventory.Product
import retrofit2.Call
import retrofit2.http.*

private const val PRODUCTS_API_URL = "api/Products"

interface ProductsAPI {
    @Headers("Content-Type: application/json")
    @POST(PRODUCTS_API_URL)
    fun saveProduct(@Body product: Product): Call<Product>

    @Headers("Content-Type: application/json")
    @GET(PRODUCTS_API_URL)
    fun getProducts(): Call<List<Product>>

    @Headers("Content-Type: application/json")
    @GET("$PRODUCTS_API_URL/{code}")
    fun getProduct(@Path("code") code: String): Call<Product>

    @Headers("Content-Type: application/json")
    @PUT("$PRODUCTS_API_URL/{code}")
    fun updateProduct(@Path("code") code: String, @Body product: Product): Call<Product>
}
