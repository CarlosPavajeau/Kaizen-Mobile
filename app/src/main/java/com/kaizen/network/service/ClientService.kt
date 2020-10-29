package com.kaizen.network.service

import com.kaizen.model.client.Client
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.ClientsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClientService {
    private val clientsAPI = ApiServiceBuilder.buildApiService(ClientsAPI::class.java)

    fun saveClient(client: Client, apiCallback: ApiCallback<Client>) {
        clientsAPI.saveClient(client).enqueue(
            object : Callback<Client> {
                override fun onResponse(call: Call<Client>, response: Response<Client>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Client>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getClients(apiCallback: ApiCallback<List<Client>>) {
        clientsAPI.getClients().enqueue(
            object : Callback<List<Client>> {
                override fun onResponse(
                    call: Call<List<Client>>,
                    response: Response<List<Client>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<Client>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getClient(id: String, apiCallback: ApiCallback<Client>) {
        clientsAPI.getClient(id).enqueue(
            object : Callback<Client> {
                override fun onResponse(call: Call<Client>, response: Response<Client>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Client>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun getClientRequests(apiCallback: ApiCallback<List<Client>>) {
        clientsAPI.getClientRequests().enqueue(
            object : Callback<List<Client>> {
                override fun onResponse(
                    call: Call<List<Client>>,
                    response: Response<List<Client>>
                ) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<List<Client>>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }

    fun updateClient(client: Client, apiCallback: ApiCallback<Client>) {
        clientsAPI.updateClient(client.id, client).enqueue(
            object : Callback<Client> {
                override fun onResponse(call: Call<Client>, response: Response<Client>) {
                    apiCallback.onResponse(response.body())
                }

                override fun onFailure(call: Call<Client>, t: Throwable) {
                    apiCallback.onFailure(t)
                }

            }
        )
    }
}
