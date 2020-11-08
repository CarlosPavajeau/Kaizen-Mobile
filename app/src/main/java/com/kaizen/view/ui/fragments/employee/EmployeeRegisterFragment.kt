package com.kaizen.view.ui.fragments.employee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kaizen.R

/**
 * A simple [Fragment] subclass.
 * Use the [EmployeeRegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmployeeRegisterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_register, container, false)
    }
}
