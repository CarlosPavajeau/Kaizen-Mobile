package com.kaizen.network

import com.kaizen.model.applicationuser.ApplicationUser
import com.kaizen.model.applicationuser.ChangePasswordRequest
import com.kaizen.model.applicationuser.LoginRequest
import com.kaizen.model.applicationuser.ResetPasswordModel
import retrofit2.Call
import retrofit2.http.*

private const val USERS_API_URL = "api/Users"

interface ApplicationUsersAPI {
    @Headers("Content-Type: application/json")
    @POST(USERS_API_URL)
    fun saveApplicationUser(@Body() applicationUser: ApplicationUser): Call<ApplicationUser>

    @Headers("Content-Type: application/json")
    @POST("$USERS_API_URL/Login")
    fun login(@Body() loginRequest: LoginRequest): Call<ApplicationUser>

    @Headers("Content-Type: application/json")
    @POST("$USERS_API_URL/ConfirmEmail")
    fun confirmEmail(
        @Query("email") email: String,
        @Query("token") token: String
    ): Call<ApplicationUser>

    @Headers("Content-Type: application/json")
    @POST("$USERS_API_URL/ForgottenPassword")
    fun forgottenPassword(@Query("usernameOrEmail") usernameOrEmail: String): Call<Boolean>

    @Headers("Content-Type: application/json")
    @GET("$USERS_API_URL/{id}")
    fun getUser(@Path("id") userId: String): Call<ApplicationUser>

    @Headers("Content-Type: application/json")
    @GET("$USERS_API_URL/CheckExists/{usernameOrEmailOrPhone}")
    fun checkExists(@Path("usernameOrEmailOrPhone") usernameOrEmailOrPhone: String): Call<Boolean>

    @Headers("Content-Type: application/json")
    @PUT("$USERS_API_URL/ChangePassword/{id}")
    fun changePassword(
        @Path("id") id: String,
        @Body() changePasswordRequest: ChangePasswordRequest
    ): Call<ApplicationUser>

    @Headers("Content-Type: application/json")
    @PUT("$USERS_API_URL/ResetPassword/{usernameOrEmail}")
    fun resetPassword(
        @Path("usernameOrEmail") usernameOrEmail: String,
        @Body() resetPasswordModel: ResetPasswordModel
    ): Call<ApplicationUser>
}
