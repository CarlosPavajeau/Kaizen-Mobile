package com.kaizen.view.ui.fragments.activityschedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.kaizen.R
import com.kaizen.model.activityschedule.Activity
import com.kaizen.network.ApiCallback
import com.kaizen.view.adapter.CalendarDayAdapter
import com.kaizen.view.adapter.TapListener
import com.kaizen.viewmodel.ActivityViewModel
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [CalendarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalendarFragment : Fragment(), TapListener<Activity> {
    private lateinit var activityViewModel: ActivityViewModel
    private lateinit var calendarDayAdapter: CalendarDayAdapter
    private lateinit var calendarDayActivityAdapter: CalendarDayAdapter

    lateinit var calendarDays: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calendarDays = view.findViewById(R.id.rv_calendar_days)
        activityViewModel = ActivityViewModel(view.context)
        calendarDayAdapter = CalendarDayAdapter(this)

        activityViewModel.getActivities(object : ApiCallback<List<Activity>> {
            override fun onResponse(result: Response<List<Activity>>) {
                if (result.isSuccessful) {
                    val activities = result.body()
                    if (activities != null) {
                        calendarDayAdapter.updateData(activities)
                    }
                }
            }

            override fun onFailure(error: Throwable) {
                println(error)
            }

        })
    }

    override fun onTap(data: Activity) {
        println(data)
    }
}
