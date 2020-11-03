package com.kaizen.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kaizen.R
import com.kaizen.model.servicerequest.ServiceRequest
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class PendingServiceRequestAdapter(private val tapListener: TapListener<ServiceRequest>) :
    RecyclerView.Adapter<PendingServiceRequestAdapter.ViewHolder>() {
    var serviceRequests = ArrayList<ServiceRequest>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clientName: TextView = itemView.findViewById(R.id.tv_service_request_client)
        val date: TextView = itemView.findViewById(R.id.tv_service_request_date)
        val periodicity: TextView = itemView.findViewById(R.id.tv_service_request_periodicity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pending_service_request, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val serviceRequest = serviceRequests[position]

        holder.clientName.text = serviceRequest.client.tradeName

        val dateFormat = SimpleDateFormat("", Locale.US)
        holder.date.text = dateFormat.format(serviceRequest.date)

        holder.periodicity.text = serviceRequest.periodicity.toString()

        holder.itemView.setOnClickListener {
            tapListener.onTap(serviceRequest)
        }
    }

    override fun getItemCount(): Int {
        return serviceRequests.size
    }

    fun updateData(data: List<ServiceRequest>) {
        serviceRequests.clear()
        serviceRequests.addAll(data)
        notifyDataSetChanged()
    }
}
