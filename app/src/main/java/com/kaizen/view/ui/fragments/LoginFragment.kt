package com.kaizen.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout
import com.kaizen.R

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var userOrPasswordInput: TextInputLayout
    private lateinit var passwordInput: TextInputLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userOrPasswordInput = view.findViewById(R.id.et_user_or_email)
        passwordInput = view.findViewById(R.id.et_password)

        val btLogin = view.findViewById<Button>(R.id.bt_login)
        btLogin.setOnClickListener {
            println("Click")
        }
    }
}
