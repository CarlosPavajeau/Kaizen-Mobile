package com.kaizen.network.service

import com.kaizen.model.inventory.Product
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.ProductsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductService {
    private val productsAPI = ApiServiceBuilder.buildApiService(ProductsAPI::class.java)

    fun saveProduct(product: Product, apiCallback: ApiCallback<Product>) {
        productsAPI.saveProduct(product).enqueue(
            object : Callback<Product> {
                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Product>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getProducts(apiCallback: ApiCallback<List<Product>>) {
        productsAPI.getProducts().enqueue(
            object : Callback<List<Product>> {
                override fun onResponse(
                    call: Call<List<Product>>,
                    response: Response<List<Product>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getProduct(code: String, apiCallback: ApiCallback<Product>) {
        productsAPI.getProduct(code).enqueue(
            object : Callback<Product> {
                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Product>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun updateProduct(product: Product, apiCallback: ApiCallback<Product>) {
        productsAPI.updateProduct(product.code, product).enqueue(
            object : Callback<Product> {
                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Product>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }
}
