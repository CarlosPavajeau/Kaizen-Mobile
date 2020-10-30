package com.kaizen.network.service

import com.kaizen.model.service.Service
import com.kaizen.model.service.ServiceType
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.api.ServicesAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceService {
    private val servicesApi = ApiServiceBuilder.buildApiService(ServicesAPI::class.java)

    fun saveService(service: Service, apiCallback: ApiCallback<Service>) {
        servicesApi.saveService(service).enqueue(
            object : Callback<Service> {
                override fun onResponse(call: Call<Service>, response: Response<Service>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Service>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getServices(apiCallback: ApiCallback<List<Service>>) {
        servicesApi.getServices().enqueue(
            object : Callback<List<Service>> {
                override fun onResponse(
                    call: Call<List<Service>>,
                    response: Response<List<Service>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<Service>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getServiceTypes(apiCallback: ApiCallback<List<ServiceType>>) {
        servicesApi.getServiceTypes().enqueue(
            object : Callback<List<ServiceType>> {
                override fun onResponse(
                    call: Call<List<ServiceType>>,
                    response: Response<List<ServiceType>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<ServiceType>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getService(code: String, apiCallback: ApiCallback<Service>) {
        servicesApi.getService(code).enqueue(
            object : Callback<Service> {
                override fun onResponse(call: Call<Service>, response: Response<Service>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Service>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun updateService(service: Service, apiCallback: ApiCallback<Service>) {
        servicesApi.updateService(service.code, service).enqueue(
            object : Callback<Service> {
                override fun onResponse(call: Call<Service>, response: Response<Service>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Service>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }
}
