package com.kaizen.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaizen.R
import com.kaizen.model.activityschedule.Activity
import com.kaizen.model.activityschedule.ActivityDay

class CalendarDayAdapter(private val tapListener: TapListener<Activity>) :
    RecyclerView.Adapter<CalendarDayAdapter.ViewHolder>() {
    var activityDays = ArrayList<ActivityDay>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val weekDay: TextView = itemView.findViewById(R.id.tv_calendar_week_day)
        val dayNumber: TextView = itemView.findViewById(R.id.tv_calendar_day_number)
        val calendarDayActivities: RecyclerView =
            itemView.findViewById(R.id.rv_calendar_day_activities)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_calendar_day, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activityDay = activityDays[position]

        holder.weekDay.text = activityDay.name
        holder.dayNumber.text = activityDay.number.toString()

        holder.calendarDayActivities.apply {
            layoutManager =
                LinearLayoutManager(holder.itemView.context, LinearLayoutManager.VERTICAL, false)
            adapter = CalendarDayActivityAdapter(tapListener)
        }
    }

    override fun getItemCount(): Int {
        return activityDays.size
    }

    fun updateData(activities: List<Activity>) {
        activityDays.clear()

        var mapActivities = activities.groupBy { it.date.day }
        mapActivities.forEach {
            var activityDay = ActivityDay("Day", it.key)
            activityDay.activities = it.value
            activityDay.date = it.value[0].date

            activityDays.add(activityDay)
        }
    }
}
