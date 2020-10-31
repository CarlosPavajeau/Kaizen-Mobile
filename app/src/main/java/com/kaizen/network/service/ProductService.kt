package com.kaizen.network.service

import android.content.Context
import com.kaizen.model.inventory.Product
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.ProductsAPI

class ProductService(context: Context) {
    private val productsAPI = ApiServiceBuilder.buildApiService(ProductsAPI::class.java, context)

    fun saveProduct(product: Product, apiCallback: ApiCallback<Product>) {
        productsAPI.saveProduct(product).enqueue(Callback(apiCallback))
    }

    fun getProducts(apiCallback: ApiCallback<List<Product>>) {
        productsAPI.getProducts().enqueue(Callback(apiCallback))
    }

    fun getProduct(code: String, apiCallback: ApiCallback<Product>) {
        productsAPI.getProduct(code).enqueue(Callback(apiCallback))
    }

    fun updateProduct(product: Product, apiCallback: ApiCallback<Product>) {
        productsAPI.updateProduct(product.code, product).enqueue(Callback(apiCallback))
    }
}
