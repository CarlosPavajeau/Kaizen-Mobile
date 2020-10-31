package com.kaizen.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kaizen.model.applicationuser.ApplicationUser
import com.kaizen.model.applicationuser.ChangePasswordRequest
import com.kaizen.model.applicationuser.LoginRequest
import com.kaizen.model.applicationuser.ResetPasswordModel
import com.kaizen.network.ApiCallback
import com.kaizen.network.service.ApplicationUserService

class ApplicationUserViewModel(context: Context) : ViewModel() {
    private val applicationUserService = ApplicationUserService(context)

    fun saveApplicationUser(
        applicationUser: ApplicationUser,
        apiCallback: ApiCallback<ApplicationUser>
    ) {
        applicationUserService.saveApplicationUser(applicationUser, apiCallback)
    }

    fun login(loginRequest: LoginRequest, apiCallback: ApiCallback<ApplicationUser>) {
        applicationUserService.login(loginRequest, apiCallback)
    }

    fun confirmEmail(email: String, token: String, apiCallback: ApiCallback<ApplicationUser>) {
        applicationUserService.confirmEmail(email, token, apiCallback)
    }

    fun forgottenPassword(usernameOrEmail: String, apiCallback: ApiCallback<Boolean>) {
        applicationUserService.forgottenPassword(usernameOrEmail, apiCallback)
    }

    fun getUser(id: String, apiCallback: ApiCallback<ApplicationUser>) {
        applicationUserService.getUser(id, apiCallback)
    }

    fun checkExists(usernameOrEmailOrPhone: String, apiCallback: ApiCallback<Boolean>) {
        applicationUserService.checkExists(usernameOrEmailOrPhone, apiCallback)
    }

    fun changePassword(
        id: String,
        changePasswordRequest: ChangePasswordRequest,
        apiCallback: ApiCallback<ApplicationUser>
    ) {
        applicationUserService.changePassword(id, changePasswordRequest, apiCallback)
    }

    fun resetPassword(
        usernameOrEmail: String,
        resetPasswordModel: ResetPasswordModel,
        apiCallback: ApiCallback<ApplicationUser>
    ) {
        applicationUserService.resetPassword(usernameOrEmail, resetPasswordModel, apiCallback)
    }
}
