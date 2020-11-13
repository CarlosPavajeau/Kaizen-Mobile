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

class PendingActivityAdapter(private val tapListener: TapListener<Activity>) :
    RecyclerView.Adapter<PendingActivityAdapter.ViewHolder>() {
    var pendingActivities = ArrayList<Activity>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val activityType: TextView = itemView.findViewById(R.id.tv_activity_code)
        val activityDate: TextView = itemView.findViewById(R.id.tv_activity_date)
        val activityHour: TextView = itemView.findViewById(R.id.tv_activity_hour)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pending_activity, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = pendingActivities[position]

        holder.activityType.text = activity.code.toString()

        val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.US)
        holder.activityDate.text = dateFormat.format(activity.date)

        val hourFormat = SimpleDateFormat("hh:mm a", Locale.US)
        holder.activityHour.text = hourFormat.format(activity.date)

        holder.itemView.setOnClickListener {
            tapListener.onTap(activity)
        }
    }

    override fun getItemCount(): Int {
        return pendingActivities.size
    }

    fun updateData(data: List<Activity>) {
        pendingActivities.clear()
        pendingActivities.addAll(data)
        notifyDataSetChanged()
    }
}
