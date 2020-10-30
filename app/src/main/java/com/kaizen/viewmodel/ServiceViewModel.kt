package com.kaizen.viewmodel

import androidx.lifecycle.ViewModel
import com.kaizen.model.service.Service
import com.kaizen.model.service.ServiceType
import com.kaizen.network.ApiCallback
import com.kaizen.network.service.ServiceService

class ServiceViewModel : ViewModel() {
    private val serviceService = ServiceService()

    fun saveService(service: Service, apiCallback: ApiCallback<Service>) {
        serviceService.saveService(service, apiCallback)
    }

    fun getServices(apiCallback: ApiCallback<List<Service>>) {
        serviceService.getServices(apiCallback)
    }

    fun getServiceTypes(apiCallback: ApiCallback<List<ServiceType>>) {
        serviceService.getServiceTypes(apiCallback)
    }

    fun getService(code: String, apiCallback: ApiCallback<Service>) {
        serviceService.getService(code, apiCallback)
    }

    fun updateService(service: Service, apiCallback: ApiCallback<Service>) {
        serviceService.updateService(service, apiCallback)
    }
}
