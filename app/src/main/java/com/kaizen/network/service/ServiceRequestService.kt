package com.kaizen.network.service

import com.kaizen.model.servicerequest.ServiceRequest
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.ServiceRequestsAPI

class ServiceRequestService {
    private val serviceRequestsApi =
        ApiServiceBuilder.buildApiService(ServiceRequestsAPI::class.java)

    fun saveServiceRequest(
        serviceRequest: ServiceRequest,
        apiCallback: ApiCallback<ServiceRequest>
    ) {
        serviceRequestsApi.saveServiceRequest(serviceRequest)
            .enqueue(Callback(apiCallback))
    }

    fun getServiceRequests(apiCallback: ApiCallback<List<ServiceRequest>>) {
        serviceRequestsApi.getServiceRequests().enqueue(Callback(apiCallback))
    }

    fun getPendingServiceRequest(clientId: String, apiCallback: ApiCallback<ServiceRequest>) {
        serviceRequestsApi.getPendingServiceRequest(clientId).enqueue(Callback(apiCallback))
    }

    fun getServiceRequest(serviceRequestCode: Int, apiCallback: ApiCallback<ServiceRequest>) {
        serviceRequestsApi.getServiceRequest(serviceRequestCode).enqueue(Callback(apiCallback))
    }

    fun updateServiceRequest(
        serviceRequest: ServiceRequest,
        apiCallback: ApiCallback<ServiceRequest>
    ) {
        serviceRequestsApi.updateServiceRequest(serviceRequest.code, serviceRequest)
            .enqueue(Callback(apiCallback))
    }
}
