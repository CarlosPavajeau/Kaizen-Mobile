package com.kaizen.network.service

import com.kaizen.model.client.Client
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.ClientsAPI

class ClientService {
    private val clientsAPI = ApiServiceBuilder.buildApiService(ClientsAPI::class.java)

    fun saveClient(client: Client, apiCallback: ApiCallback<Client>) {
        clientsAPI.saveClient(client).enqueue(Callback(apiCallback))
    }

    fun getClients(apiCallback: ApiCallback<List<Client>>) {
        clientsAPI.getClients().enqueue(Callback(apiCallback))
    }

    fun getClient(id: String, apiCallback: ApiCallback<Client>) {
        clientsAPI.getClient(id).enqueue(Callback(apiCallback))
    }

    fun getClientRequests(apiCallback: ApiCallback<List<Client>>) {
        clientsAPI.getClientRequests().enqueue(Callback(apiCallback))
    }

    fun updateClient(client: Client, apiCallback: ApiCallback<Client>) {
        clientsAPI.updateClient(client.id, client).enqueue(Callback(apiCallback))
    }
}
