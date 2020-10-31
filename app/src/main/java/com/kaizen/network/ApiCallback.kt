package com.kaizen.network

import retrofit2.Response

interface ApiCallback<T> {
    fun onResponse(result: Response<T>)
    fun onFailure(error: Throwable)
}
