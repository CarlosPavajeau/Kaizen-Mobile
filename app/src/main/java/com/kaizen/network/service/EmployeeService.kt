package com.kaizen.network.service

import com.kaizen.model.employee.Employee
import com.kaizen.model.employee.EmployeeCharge
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.EmployeesAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class EmployeeService {
    private val employeesAPI = ApiServiceBuilder.buildApiService(EmployeesAPI::class.java)

    fun saveEmployee(employee: Employee, apiCallback: ApiCallback<Employee>) {
        employeesAPI.saveEmployee(employee).enqueue(
            object : Callback<Employee> {
                override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Employee>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getEmployees(apiCallback: ApiCallback<List<Employee>>) {
        employeesAPI.getEmployees().enqueue(
            object : Callback<List<Employee>> {
                override fun onResponse(
                    call: Call<List<Employee>>,
                    response: Response<List<Employee>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getEmployeeCharges(apiCallback: ApiCallback<List<EmployeeCharge>>) {
        employeesAPI.getEmployeeCharges().enqueue(
            object : Callback<List<EmployeeCharge>> {
                override fun onResponse(
                    call: Call<List<EmployeeCharge>>,
                    response: Response<List<EmployeeCharge>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<EmployeeCharge>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getEmployee(id: String, apiCallback: ApiCallback<Employee>) {
        employeesAPI.getEmployee(id).enqueue(
            object : Callback<Employee> {
                override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Employee>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getTechniciansAvailable(
        date: Date,
        serviceCodes: Array<String>,
        apiCallback: ApiCallback<List<Employee>>
    ) {
        employeesAPI.getTechniciansAvailable(date, serviceCodes).enqueue(
            object : Callback<List<Employee>> {
                override fun onResponse(
                    call: Call<List<Employee>>,
                    response: Response<List<Employee>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun updateEmployee(employee: Employee, apiCallback: ApiCallback<Employee>) {
        employeesAPI.updateEmployee(employee.id, employee).enqueue(
            object : Callback<Employee> {
                override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Employee>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }
}
