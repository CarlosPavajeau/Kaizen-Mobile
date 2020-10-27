package com.kaizen.network

import retrofit2.http.Headers
import retrofit2.http.POST

interface ApplicationUsersAPI {
    @Headers("")
    @POST("")
    fun saveUser()
}
