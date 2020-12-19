package com.kaizen.view.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.auth0.android.jwt.JWT
import com.kaizen.R
import com.kaizen.network.SessionManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sessionManager = SessionManager(this)
        val token = sessionManager.getAuthToken()
        if (token != null) {
            val jwt = JWT(token)
            val intent: Intent? = when (jwt.getClaim("role").asString()) {
                "Client" -> {
                    Intent(this, ClientActivity::class.java)
                }
                "Administrator" -> {
                    Intent(this, AdministratorActivity::class.java)
                }
                "OfficeEmployee" -> {
                    Intent(this, OfficeEmployeeActivity::class.java)
                }
                "TechnicalEmployee" -> {
                    Intent(this, TechnicianEmployeeActivity::class.java)
                }
                else -> {
                    null
                }
            }

            if (intent != null) {
                startActivity(intent)
            }
        }
    }
}
