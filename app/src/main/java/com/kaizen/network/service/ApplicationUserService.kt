package com.kaizen.network.service

import com.kaizen.model.applicationuser.ApplicationUser
import com.kaizen.model.applicationuser.ChangePasswordRequest
import com.kaizen.model.applicationuser.LoginRequest
import com.kaizen.model.applicationuser.ResetPasswordModel
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.ApplicationUsersAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApplicationUserService {
    private val applicationUsersAPI =
        ApiServiceBuilder.buildApiService(ApplicationUsersAPI::class.java)

    fun saveApplicationUser(
        applicationUser: ApplicationUser,
        apiCallback: ApiCallback<ApplicationUser>
    ) {
        applicationUsersAPI.saveApplicationUser(applicationUser).enqueue(
            object : Callback<ApplicationUser> {
                override fun onResponse(
                    call: Call<ApplicationUser>,
                    response: Response<ApplicationUser>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<ApplicationUser>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun login(loginRequest: LoginRequest, apiCallback: ApiCallback<ApplicationUser>) {
        applicationUsersAPI.login(loginRequest).enqueue(
            object : Callback<ApplicationUser> {
                override fun onResponse(
                    call: Call<ApplicationUser>,
                    response: Response<ApplicationUser>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<ApplicationUser>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun confirmEmail(email: String, token: String, apiCallback: ApiCallback<ApplicationUser>) {
        applicationUsersAPI.confirmEmail(email, token).enqueue(
            object : Callback<ApplicationUser> {
                override fun onResponse(
                    call: Call<ApplicationUser>,
                    response: Response<ApplicationUser>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<ApplicationUser>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun forgottenPassword(usernameOrEmail: String, apiCallback: ApiCallback<Boolean>) {
        applicationUsersAPI.forgottenPassword(usernameOrEmail).enqueue(
            object : Callback<Boolean> {
                override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Boolean>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getUser(id: String, apiCallback: ApiCallback<ApplicationUser>) {
        applicationUsersAPI.getUser(id).enqueue(
            object : Callback<ApplicationUser> {
                override fun onResponse(
                    call: Call<ApplicationUser>,
                    response: Response<ApplicationUser>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<ApplicationUser>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun checkExists(usernameOrEmailOrPhone: String, apiCallback: ApiCallback<Boolean>) {
        applicationUsersAPI.checkExists(usernameOrEmailOrPhone).enqueue(
            object : Callback<Boolean> {
                override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Boolean>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun changePassword(
        id: String,
        changePasswordRequest: ChangePasswordRequest,
        apiCallback: ApiCallback<ApplicationUser>
    ) {
        applicationUsersAPI.changePassword(id, changePasswordRequest).enqueue(
            object : Callback<ApplicationUser> {
                override fun onResponse(
                    call: Call<ApplicationUser>,
                    response: Response<ApplicationUser>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<ApplicationUser>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun resetPassword(
        usernameOrEmail: String,
        resetPasswordModel: ResetPasswordModel,
        apiCallback: ApiCallback<ApplicationUser>
    ) {
        applicationUsersAPI.resetPassword(usernameOrEmail, resetPasswordModel).enqueue(
            object : Callback<ApplicationUser> {
                override fun onResponse(
                    call: Call<ApplicationUser>,
                    response: Response<ApplicationUser>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<ApplicationUser>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }
}
