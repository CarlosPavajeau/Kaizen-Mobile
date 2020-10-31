package com.kaizen.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kaizen.model.servicerequest.ServiceRequest
import com.kaizen.network.ApiCallback
import com.kaizen.network.service.ServiceRequestService

class ServiceRequestViewModel(context: Context) : ViewModel() {
    private val serviceRequestService = ServiceRequestService(context)

    fun saveServiceRequest(
        serviceRequest: ServiceRequest,
        apiCallback: ApiCallback<ServiceRequest>
    ) {
        serviceRequestService.saveServiceRequest(serviceRequest, apiCallback)
    }

    fun getServiceRequests(apiCallback: ApiCallback<List<ServiceRequest>>) {
        serviceRequestService.getServiceRequests(apiCallback)
    }

    fun getPendingServiceRequest(clientId: String, apiCallback: ApiCallback<ServiceRequest>) {
        serviceRequestService.getPendingServiceRequest(clientId, apiCallback)
    }

    fun getServiceRequest(serviceRequestCode: Int, apiCallback: ApiCallback<ServiceRequest>) {
        serviceRequestService.getServiceRequest(serviceRequestCode, apiCallback)
    }

    fun updateServiceRequest(
        serviceRequest: ServiceRequest,
        apiCallback: ApiCallback<ServiceRequest>
    ) {
        serviceRequestService.updateServiceRequest(serviceRequest, apiCallback)
    }
}
