package com.kaizen.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kaizen.model.inventory.Product
import com.kaizen.network.ApiCallback
import com.kaizen.network.service.ProductService

class ProductViewModel(context: Context) : ViewModel() {
    private val productService = ProductService(context)

    fun saveProduct(product: Product, apiCallback: ApiCallback<Product>) {
        productService.saveProduct(product, apiCallback)
    }

    fun getProducts(apiCallback: ApiCallback<List<Product>>) {
        productService.getProducts(apiCallback)
    }

    fun getProduct(code: String, apiCallback: ApiCallback<Product>) {
        productService.getProduct(code, apiCallback)
    }

    fun updateProduct(product: Product, apiCallback: ApiCallback<Product>) {
        productService.updateProduct(product, apiCallback)
    }
}
