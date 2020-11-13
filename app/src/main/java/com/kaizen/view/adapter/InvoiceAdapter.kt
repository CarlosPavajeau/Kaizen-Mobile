package com.kaizen.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kaizen.R
import com.kaizen.model.invoice.service.ServiceInvoice
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class InvoiceAdapter(private val tapListener: TapListener<ServiceInvoice>) :
    RecyclerView.Adapter<InvoiceAdapter.ViewHolder>() {
    var invoices = ArrayList<ServiceInvoice>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clientName: TextView = itemView.findViewById(R.id.tv_client_name_item)
        val invoiceState: TextView = itemView.findViewById(R.id.tv_invoice_state)
        val totalInvoice: TextView = itemView.findViewById(R.id.tv_total_invoice)
        val invoiceDate: TextView = itemView.findViewById(R.id.tv_invoice_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_generated_invoice, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val invoice = invoices[position]

        holder.clientName.text = invoice.client.tradeName
        holder.invoiceState.text = invoice.state.toString()
        holder.totalInvoice.text = invoice.total.toString()

        val dateFormat = SimpleDateFormat("yyyy/MM/dd hh:mm a", Locale.US)
        holder.invoiceDate.text = dateFormat.format(invoice.generationDate)

        holder.itemView.setOnClickListener {
            tapListener.onTap(invoice)
        }
    }

    override fun getItemCount(): Int {
        return invoices.size
    }

    fun updateData(data: List<ServiceInvoice>) {
        invoices.clear()
        invoices.addAll(data)
        notifyDataSetChanged()
    }
}
