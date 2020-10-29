package com.kaizen.viewmodel

import androidx.lifecycle.ViewModel
import com.kaizen.model.Employee
import com.kaizen.model.EmployeeCharge
import com.kaizen.network.ApiCallback
import com.kaizen.network.service.EmployeeService
import java.util.*

class EmployeeViewModel : ViewModel() {
    private val employeeService = EmployeeService()

    fun saveEmployee(employee: Employee, apiCallback: ApiCallback<Employee>) {
        employeeService.saveEmployee(employee, apiCallback)
    }

    fun getEmployees(apiCallback: ApiCallback<List<Employee>>) {
        employeeService.getEmployees(apiCallback)
    }

    fun getEmployeeCharges(apiCallback: ApiCallback<List<EmployeeCharge>>) {
        employeeService.getEmployeeCharges(apiCallback)
    }

    fun getEmployee(id: String, apiCallback: ApiCallback<Employee>) {
        employeeService.getEmployee(id, apiCallback)
    }

    fun getTechniciansAvailable(
        date: Date,
        serviceCodes: Array<String>,
        apiCallback: ApiCallback<List<Employee>>
    ) {
        employeeService.getTechniciansAvailable(date, serviceCodes, apiCallback)
    }

    fun updateEmployee(employee: Employee, apiCallback: ApiCallback<Employee>) {
        employeeService.updateEmployee(employee, apiCallback)
    }
}
