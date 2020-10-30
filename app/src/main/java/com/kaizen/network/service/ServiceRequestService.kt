package com.kaizen.network.service

import com.kaizen.model.servicerequest.ServiceRequest
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.api.ServiceRequestsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceRequestService {
    private val serviceRequestsApi =
        ApiServiceBuilder.buildApiService(ServiceRequestsAPI::class.java)

    fun saveServiceRequest(
        serviceRequest: ServiceRequest,
        apiCallback: ApiCallback<ServiceRequest>
    ) {
        serviceRequestsApi.saveServiceRequest(serviceRequest).enqueue(
            object : Callback<ServiceRequest> {
                override fun onResponse(
                    call: Call<ServiceRequest>,
                    response: Response<ServiceRequest>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<ServiceRequest>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getServiceRequests(apiCallback: ApiCallback<List<ServiceRequest>>) {
        serviceRequestsApi.getServiceRequests().enqueue(
            object : Callback<List<ServiceRequest>> {
                override fun onResponse(
                    call: Call<List<ServiceRequest>>,
                    response: Response<List<ServiceRequest>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<ServiceRequest>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getPendingServiceRequest(clientId: String, apiCallback: ApiCallback<ServiceRequest>) {
        serviceRequestsApi.getPendingServiceRequest(clientId).enqueue(
            object : Callback<ServiceRequest> {
                override fun onResponse(
                    call: Call<ServiceRequest>,
                    response: Response<ServiceRequest>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<ServiceRequest>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getServiceRequest(serviceRequestCode: Int, apiCallback: ApiCallback<ServiceRequest>) {
        serviceRequestsApi.getServiceRequest(serviceRequestCode).enqueue(
            object : Callback<ServiceRequest> {
                override fun onResponse(
                    call: Call<ServiceRequest>,
                    response: Response<ServiceRequest>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<ServiceRequest>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun updateServiceRequest(
        serviceRequest: ServiceRequest,
        apiCallback: ApiCallback<ServiceRequest>
    ) {
        serviceRequestsApi.updateServiceRequest(serviceRequest.code, serviceRequest).enqueue(
            object : Callback<ServiceRequest> {
                override fun onResponse(
                    call: Call<ServiceRequest>,
                    response: Response<ServiceRequest>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<ServiceRequest>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }
}
