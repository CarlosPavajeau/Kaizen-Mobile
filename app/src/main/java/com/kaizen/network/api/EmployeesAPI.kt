package com.kaizen.network.api

import com.kaizen.model.employee.Employee
import com.kaizen.model.employee.EmployeeCharge
import com.kaizen.network.ApiUrls.EMPLOYEES_API_URL
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface EmployeesAPI {
    @POST(EMPLOYEES_API_URL)
    fun saveEmployee(@Body employee: Employee): Call<Employee>

    @GET(EMPLOYEES_API_URL)
    fun getEmployees(): Call<List<Employee>>

    @GET("$EMPLOYEES_API_URL/EmployeeCharges")
    fun getEmployeeCharges(): Call<List<EmployeeCharge>>

    @GET("$EMPLOYEES_API_URL/{id}")
    fun getEmployee(@Path("id") id: String): Call<Employee>

    @GET("$EMPLOYEES_API_URL/TechniciansAvailable")
    fun getTechniciansAvailable(
        @Query("date") date: Date,
        @Query("serviceCodes") serviceCodes: Array<String>
    ): Call<List<Employee>>

    @PUT("$EMPLOYEES_API_URL/{id}")
    fun updateEmployee(@Path("id") id: String, @Body employee: Employee): Call<Employee>
}
