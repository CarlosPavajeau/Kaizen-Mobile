package com.kaizen.view.ui.fragments.applicationuser

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.auth0.android.jwt.JWT
import com.google.android.material.textfield.TextInputLayout
import com.kaizen.R
import com.kaizen.model.applicationuser.ApplicationUser
import com.kaizen.model.applicationuser.LoginRequest
import com.kaizen.network.ApiCallback
import com.kaizen.network.SessionManager
import com.kaizen.view.ui.activities.AdministratorActivity
import com.kaizen.view.ui.activities.ClientActivity
import com.kaizen.view.ui.activities.OfficeEmployeeActivity
import com.kaizen.view.ui.activities.TechnicianEmployeeActivity
import com.kaizen.viewmodel.ApplicationUserViewModel
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var userOrEmailInput: TextInputLayout
    private lateinit var passwordInput: TextInputLayout
    private lateinit var loginErrors: TextView
    private lateinit var applicationUserViewModel: ApplicationUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        applicationUserViewModel = ApplicationUserViewModel(view.context)

        userOrEmailInput = view.findViewById(R.id.et_user_or_email)
        passwordInput = view.findViewById(R.id.et_password)
        loginErrors = view.findViewById(R.id.tv_login_errors)

        val btLogin = view.findViewById<Button>(R.id.bt_login)
        btLogin.setOnClickListener {
            onLogin(view.context)
        }
    }

    private fun onLogin(context: Context) {
        val userOrEmail = userOrEmailInput.editText?.text.toString()
        val password = passwordInput.editText?.text.toString()

        if (userOrEmail.isNotEmpty() && password.isNotEmpty()) {
            loginErrors.visibility = View.INVISIBLE

            val loginRequest = LoginRequest(userOrEmail, password)
            applicationUserViewModel.login(loginRequest, object : ApiCallback<ApplicationUser> {
                override fun onResponse(result: Response<ApplicationUser>) {
                    if (result.isSuccessful) {
                        val sessionManager = SessionManager(context)
                        val applicationUser = result.body()
                        if (applicationUser != null) {
                            onLoginSuccess(applicationUser, sessionManager)
                        }
                    } else {
                        onLoginFailure(result.errorBody()?.string())
                    }
                }

                override fun onFailure(error: Throwable) {
                    onLoginFailure(error.message)
                }

            })
        }
    }

    private fun onLoginSuccess(applicationUser: ApplicationUser, sessionManager: SessionManager) {
        sessionManager.saveCurrentUser(
            applicationUser.token,
            applicationUser.id
        )

        val jwt = JWT(applicationUser.token)
        val intent: Intent? = when (jwt.getClaim("role").asString()) {
            "Client" -> {
                Intent(context, ClientActivity::class.java)
            }
            "Administrator" -> {
                Intent(context, AdministratorActivity::class.java)
            }
            "OfficeEmployee" -> {
                Intent(context, OfficeEmployeeActivity::class.java)
            }
            "TechnicalEmployee" -> {
                Intent(context, TechnicianEmployeeActivity::class.java)
            }
            else -> {
                null
            }
        }

        if (intent != null) {
            startActivity(intent)
        } else {
            onLoginFailure("Invalid user role.")
        }
    }

    private fun onLoginFailure(error: String?) {
        loginErrors.text = error
        loginErrors.visibility = View.VISIBLE
        println(error)
    }
}
