package com.kaizen.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kaizen.R
import com.kaizen.model.activityschedule.Activity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class LastClientAdapter(private val tapListener: TapListener<Activity>) :
    RecyclerView.Adapter<LastClientAdapter.ViewHolder>() {
    var activities = ArrayList<Activity>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clientName: TextView = itemView.findViewById(R.id.tv_client_name_item)
        val visitHour: TextView = itemView.findViewById(R.id.tv_hour_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_last_visited_client, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = activities[position]

        holder.clientName.text = activity.client.firstName

        val dateFormat = SimpleDateFormat("HH:mm a", Locale.US)
        holder.visitHour.text = dateFormat.format(activity.date)

        holder.itemView.setOnClickListener {
            tapListener.onTap(activity)
        }
    }

    override fun getItemCount(): Int {
        return activities.size
    }

    fun updateData(data: List<Activity>) {
        activities.clear()
        activities.addAll(data)
        notifyDataSetChanged()
    }
}
