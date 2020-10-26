package com.kaizen.network

interface ApiCallback<T> {
    fun onResponse(result: T?)
    fun onFailure(error: Throwable)
}