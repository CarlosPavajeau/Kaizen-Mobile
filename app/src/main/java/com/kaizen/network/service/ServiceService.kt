package com.kaizen.network.service

import com.kaizen.model.service.Service
import com.kaizen.model.service.ServiceType
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.ServicesAPI

class ServiceService {
    private val servicesApi = ApiServiceBuilder.buildApiService(ServicesAPI::class.java)

    fun saveService(service: Service, apiCallback: ApiCallback<Service>) {
        servicesApi.saveService(service).enqueue(Callback(apiCallback))
    }

    fun getServices(apiCallback: ApiCallback<List<Service>>) {
        servicesApi.getServices().enqueue(Callback(apiCallback))
    }

    fun getServiceTypes(apiCallback: ApiCallback<List<ServiceType>>) {
        servicesApi.getServiceTypes().enqueue(Callback(apiCallback))
    }

    fun getService(code: String, apiCallback: ApiCallback<Service>) {
        servicesApi.getService(code).enqueue(Callback(apiCallback))
    }

    fun updateService(service: Service, apiCallback: ApiCallback<Service>) {
        servicesApi.updateService(service.code, service).enqueue(Callback(apiCallback))
    }
}
