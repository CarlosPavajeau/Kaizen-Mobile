package com.kaizen.network.service

import android.content.Context
import com.kaizen.model.employee.Employee
import com.kaizen.model.employee.EmployeeCharge
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.EmployeesAPI
import java.util.*

class EmployeeService(context: Context) {
    private val employeesAPI = ApiServiceBuilder.buildApiService(EmployeesAPI::class.java, context)

    fun saveEmployee(employee: Employee, apiCallback: ApiCallback<Employee>) {
        employeesAPI.saveEmployee(employee).enqueue(Callback(apiCallback))
    }

    fun getEmployees(apiCallback: ApiCallback<List<Employee>>) {
        employeesAPI.getEmployees().enqueue(Callback(apiCallback))
    }

    fun getEmployeeCharges(apiCallback: ApiCallback<List<EmployeeCharge>>) {
        employeesAPI.getEmployeeCharges().enqueue(Callback(apiCallback))
    }

    fun getEmployee(id: String, apiCallback: ApiCallback<Employee>) {
        employeesAPI.getEmployee(id).enqueue(Callback(apiCallback))
    }

    fun getTechniciansAvailable(
        date: Date,
        serviceCodes: Array<String>,
        apiCallback: ApiCallback<List<Employee>>
    ) {
        employeesAPI.getTechniciansAvailable(date, serviceCodes).enqueue(Callback(apiCallback))
    }

    fun updateEmployee(employee: Employee, apiCallback: ApiCallback<Employee>) {
        employeesAPI.updateEmployee(employee.id, employee).enqueue(Callback(apiCallback))
    }
}
