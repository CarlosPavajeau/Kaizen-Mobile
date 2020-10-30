package com.kaizen.network.service

import com.kaizen.model.applicationuser.ApplicationUser
import com.kaizen.model.applicationuser.ChangePasswordRequest
import com.kaizen.model.applicationuser.LoginRequest
import com.kaizen.model.applicationuser.ResetPasswordModel
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.ApplicationUsersAPI

class ApplicationUserService {
    private val applicationUsersAPI =
        ApiServiceBuilder.buildApiService(ApplicationUsersAPI::class.java)

    fun saveApplicationUser(
        applicationUser: ApplicationUser,
        apiCallback: ApiCallback<ApplicationUser>
    ) {
        applicationUsersAPI.saveApplicationUser(applicationUser).enqueue(Callback(apiCallback))
    }

    fun login(loginRequest: LoginRequest, apiCallback: ApiCallback<ApplicationUser>) {
        applicationUsersAPI.login(loginRequest).enqueue(Callback(apiCallback))
    }

    fun confirmEmail(email: String, token: String, apiCallback: ApiCallback<ApplicationUser>) {
        applicationUsersAPI.confirmEmail(email, token).enqueue(Callback(apiCallback))
    }

    fun forgottenPassword(usernameOrEmail: String, apiCallback: ApiCallback<Boolean>) {
        applicationUsersAPI.forgottenPassword(usernameOrEmail).enqueue(Callback(apiCallback))
    }

    fun getUser(id: String, apiCallback: ApiCallback<ApplicationUser>) {
        applicationUsersAPI.getUser(id).enqueue(Callback(apiCallback))
    }

    fun checkExists(usernameOrEmailOrPhone: String, apiCallback: ApiCallback<Boolean>) {
        applicationUsersAPI.checkExists(usernameOrEmailOrPhone).enqueue(Callback(apiCallback))
    }

    fun changePassword(
        id: String,
        changePasswordRequest: ChangePasswordRequest,
        apiCallback: ApiCallback<ApplicationUser>
    ) {
        applicationUsersAPI.changePassword(id, changePasswordRequest).enqueue(Callback(apiCallback))
    }

    fun resetPassword(
        usernameOrEmail: String,
        resetPasswordModel: ResetPasswordModel,
        apiCallback: ApiCallback<ApplicationUser>
    ) {
        applicationUsersAPI.resetPassword(usernameOrEmail, resetPasswordModel)
            .enqueue(Callback(apiCallback))
    }
}
