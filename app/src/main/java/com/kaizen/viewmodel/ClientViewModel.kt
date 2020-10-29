package com.kaizen.viewmodel

import androidx.lifecycle.ViewModel
import com.kaizen.model.Client
import com.kaizen.network.ApiCallback
import com.kaizen.network.service.ClientService

class ClientViewModel : ViewModel() {
    private val clientService = ClientService()

    fun saveClient(client: Client, apiCallback: ApiCallback<Client>) {
        clientService.saveClient(client, apiCallback)
    }

    fun getClients(apiCallback: ApiCallback<List<Client>>) {
        clientService.getClients(apiCallback)
    }

    fun getClient(id: String, apiCallback: ApiCallback<Client>) {
        clientService.getClient(id, apiCallback)
    }

    fun getClientRequests(apiCallback: ApiCallback<List<Client>>) {
        clientService.getClientRequests(apiCallback)
    }

    fun updateClient(client: Client, apiCallback: ApiCallback<Client>) {
        clientService.updateClient(client, apiCallback)
    }
}
