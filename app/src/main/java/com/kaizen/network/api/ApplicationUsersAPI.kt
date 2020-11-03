package com.kaizen.network.api

import com.kaizen.model.applicationuser.ApplicationUser
import com.kaizen.model.applicationuser.ChangePasswordRequest
import com.kaizen.model.applicationuser.LoginRequest
import com.kaizen.model.applicationuser.ResetPasswordModel
import com.kaizen.network.ApiUrls.USERS_API_URL
import retrofit2.Call
import retrofit2.http.*

interface ApplicationUsersAPI {
    @POST(USERS_API_URL)
    fun saveApplicationUser(@Body() applicationUser: ApplicationUser): Call<ApplicationUser>

    @POST("$USERS_API_URL/Login")
    fun login(@Body() loginRequest: LoginRequest): Call<ApplicationUser>

    @POST("$USERS_API_URL/ConfirmEmail")
    fun confirmEmail(
        @Query("email") email: String,
        @Query("token") token: String
    ): Call<ApplicationUser>

    @POST("$USERS_API_URL/ForgottenPassword")
    fun forgottenPassword(@Query("usernameOrEmail") usernameOrEmail: String): Call<Boolean>

    @GET("$USERS_API_URL/{id}")
    fun getUser(@Path("id") userId: String): Call<ApplicationUser>

    @GET("$USERS_API_URL/CheckExists/{usernameOrEmailOrPhone}")
    fun checkExists(@Path("usernameOrEmailOrPhone") usernameOrEmailOrPhone: String): Call<Boolean>

    @PUT("$USERS_API_URL/ChangePassword/{id}")
    fun changePassword(
        @Path("id") id: String,
        @Body() changePasswordRequest: ChangePasswordRequest
    ): Call<ApplicationUser>

    @PUT("$USERS_API_URL/ResetPassword/{usernameOrEmail}")
    fun resetPassword(
        @Path("usernameOrEmail") usernameOrEmail: String,
        @Body() resetPasswordModel: ResetPasswordModel
    ): Call<ApplicationUser>
}
