package com.kaizen.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Callback<T>(private val apiCallback: ApiCallback<T>) : Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {
        apiCallback.onResponse(response.body())
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        apiCallback.onFailure(t)
    }
}
