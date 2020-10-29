package com.kaizen.network.api

import com.kaizen.model.employee.Employee
import com.kaizen.model.employee.EmployeeCharge
import retrofit2.Call
import retrofit2.http.*
import java.util.*

private const val EMPLOYEES_API_URL = "api/Employees"

interface EmployeesAPI {
    @Headers("Content-Type: application/json")
    @POST(EMPLOYEES_API_URL)
    fun saveEmployee(@Body employee: Employee): Call<Employee>

    @Headers("Content-Type: application/json")
    @GET(EMPLOYEES_API_URL)
    fun getEmployees(): Call<List<Employee>>

    @Headers("Content-Type: application/json")
    @GET("$EMPLOYEES_API_URL/EmployeeCharges")
    fun getEmployeeCharges(): Call<List<EmployeeCharge>>

    @Headers("Content-Type: application/json")
    @GET("$EMPLOYEES_API_URL/{id}")
    fun getEmployee(@Path("id") id: String): Call<Employee>

    @Headers("Content-Type: application/json")
    @GET("$EMPLOYEES_API_URL/TechniciansAvailable")
    fun getTechniciansAvailable(
        @Query("date") date: Date,
        @Query("serviceCodes") serviceCodes: Array<String>
    ): Call<List<Employee>>

    @Headers("Content-Type: application/json")
    @PUT("$EMPLOYEES_API_URL/{id}")
    fun updateEmployee(@Path("id") id: String, @Body employee: Employee): Call<Employee>
}
