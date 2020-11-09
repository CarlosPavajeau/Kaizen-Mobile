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

class CalendarDayActivityAdapter(private val tapListener: TapListener<Activity>) :
    RecyclerView.Adapter<CalendarDayActivityAdapter.ViewHolder>() {
    var activities = ArrayList<Activity>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val activityHour: TextView = itemView.findViewById(R.id.tv_activity_hour)
        val activityPeriodicity: TextView = itemView.findViewById(R.id.tv_activity_periodicity)
        val activityEmployees: TextView = itemView.findViewById(R.id.tv_activity_employees)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_calendar_day_activity, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = activities[position]

        val dateFormat = SimpleDateFormat("HH:mm a", Locale.US)
        holder.activityHour.text = dateFormat.format(activity.date)
        holder.activityPeriodicity.text = activity.periodicity.toString()
        holder.activityEmployees.text =
            activity.employees.joinToString(limit = 6, truncated = "...") {
                it.firstName
            }

        holder.itemView.setOnClickListener {
            tapListener.onTap(activity)
        }
    }

    override fun getItemCount(): Int {
        return activities.size
    }
}
