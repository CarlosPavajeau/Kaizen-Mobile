package com.kaizen.view.ui.fragments.activityschedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kaizen.R
import com.kaizen.model.activityschedule.Activity
import com.kaizen.network.ApiCallback
import com.kaizen.viewmodel.ActivityViewModel
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [ActivityDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActivityDetailFragment : Fragment() {
    private lateinit var activity: Activity
    private lateinit var activityViewModel: ActivityViewModel

    private lateinit var activityDetailTitle: TextView
    private lateinit var activityDate: TextView
    private lateinit var activityPeriodicity: TextView
    private lateinit var activityEmployees: TextView
    private lateinit var activityServices: TextView
    private lateinit var activityState: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activityCode = arguments?.getSerializable("activity") as Int
        activityViewModel = ActivityViewModel(view.context)

        activityViewModel.getActivity(activityCode, object : ApiCallback<Activity> {
            override fun onResponse(result: Response<Activity>) {
                if (result.isSuccessful) {
                    val body = result.body()
                    if (body != null) {
                        activity = body
                        onLoadActivity(view)
                    }
                }
            }

            override fun onFailure(error: Throwable) {
                println(error)
            }

        })

        activityDetailTitle = view.findViewById(R.id.activity_detail_title)
        activityDate = view.findViewById(R.id.tv_activity_date)
        activityPeriodicity = view.findViewById(R.id.tv_activity_periodicity)
        activityEmployees = view.findViewById(R.id.tv_activity_employees)
        activityServices = view.findViewById(R.id.tv_activity_services)
        activityState = view.findViewById(R.id.tv_activity_state)
    }

    private fun onLoadActivity(view: View) {
        activityDetailTitle.text =
            view.context.getString(R.string.activity_detail_title_text, activity.code)
        val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd hh:mm a", Locale.US)
        activityDate.text = simpleDateFormat.format(activity.date)
        activityPeriodicity.text = activity.periodicity.toString()
        activityEmployees.text = activity.employees.joinToString(limit = 3, truncated = "...") {
            "${it.firstName} ${it.lastName}"
        }
        activityServices.text = activity.services.joinToString(limit = 2, truncated = "...") {
            "${it.name} - ${it.cost}"
        }
        activityState.text = activity.state.toString()
    }
}
