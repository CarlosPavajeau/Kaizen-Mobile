package com.kaizen.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kaizen.R
import com.kaizen.model.client.Client

class PendingClientRequestAdapter(private val tapListener: TapListener<Client>) :
    RecyclerView.Adapter<PendingClientRequestAdapter.ViewHolder>() {
    var clientRequests = ArrayList<Client>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clientName: TextView = itemView.findViewById(R.id.tv_client_request_name)
        val phone: TextView = itemView.findViewById(R.id.tv_client_request_phone)
        val email: TextView = itemView.findViewById(R.id.tv_client_request_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pending_client_request, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val client = clientRequests[position]

        holder.clientName.text = client.tradeName
        holder.phone.text = client.firstPhoneNumber
        holder.email.text = client.user.email

        holder.itemView.setOnClickListener {
            tapListener.onTap(client)
        }
    }

    override fun getItemCount(): Int {
        return clientRequests.size
    }
}
