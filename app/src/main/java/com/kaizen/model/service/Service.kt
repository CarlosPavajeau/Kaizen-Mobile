package com.kaizen.model.service

import com.google.gson.annotations.SerializedName
import com.kaizen.model.employee.Employee
import com.kaizen.model.inventory.Equipment
import com.kaizen.model.inventory.Product

data class Service(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
) {
    @SerializedName("cost")
    var cost: Float = 0.0F

    @SerializedName("serviceTypeId")
    var serviceTypeId: Int = 0

    @SerializedName("serviceType")
    lateinit var serviceType: ServiceType

    @SerializedName("productCodes")
    lateinit var productCodes: Array<String>

    @SerializedName("equipmentCodes")
    lateinit var equipmentCodes: Array<String>

    @SerializedName("employeeCodes")
    lateinit var employeeCodes: Array<String>

    @SerializedName("products")
    lateinit var products: List<Product>

    @SerializedName("equipments")
    lateinit var equipments: List<Equipment>

    @SerializedName("employees")
    lateinit var employees: List<Employee>
}
