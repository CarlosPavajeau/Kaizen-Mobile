package com.kaizen.view.ui.fragments.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaizen.R
import com.kaizen.model.activityschedule.Activity
import com.kaizen.model.client.Client
import com.kaizen.network.ApiCallback
import com.kaizen.network.SessionManager
import com.kaizen.view.adapter.ActivityAdapter
import com.kaizen.view.adapter.PendingActivitiesAdapter
import com.kaizen.view.adapter.TapListener
import com.kaizen.viewmodel.ActivityViewModel
import com.kaizen.viewmodel.ClientViewModel
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [ClientHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClientHomeFragment : Fragment() {
    lateinit var activityViewModel: ActivityViewModel
    lateinit var clientViewModel: ClientViewModel

    lateinit var pendingActivityAdapter: ActivityAdapter
    lateinit var pendingActivitiesAdapter: PendingActivitiesAdapter
    lateinit var appliedActivitiesAdapter: ActivityAdapter

    lateinit var nextActivity: RecyclerView
    lateinit var pendingActivities: RecyclerView
    lateinit var appliedActivities: RecyclerView

    lateinit var viewMorePendingActivities: Button
    lateinit var viewMoreAppliedActivities: Button

    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_client_home, container, false)
    }

    private fun loadViewComponents(view: View) {
        nextActivity = view.findViewById(R.id.rv_next_activity)
        pendingActivities = view.findViewById(R.id.rv_pending_activities)
        appliedActivities = view.findViewById(R.id.rv_applied_activities)
        viewMorePendingActivities = view.findViewById(R.id.bt_view_more_pending_activities)
        viewMoreAppliedActivities = view.findViewById(R.id.bt_view_more_applied_activities)
    }

    private fun initViewModels(view: View) {
        activityViewModel = ActivityViewModel(view.context)
        clientViewModel = ClientViewModel(view.context)
        sessionManager = SessionManager(view.context)
    }

    private fun initAdapters(view: View) {
        val onTapActivity = object :
            TapListener<Activity> {
            override fun onTap(data: Activity) {
                println(data)
            }

        }
        pendingActivityAdapter = ActivityAdapter(onTapActivity)
        pendingActivitiesAdapter = PendingActivitiesAdapter(onTapActivity)
        appliedActivitiesAdapter = ActivityAdapter(onTapActivity)

        pendingActivityAdapter
        nextActivity.apply {
            adapter = pendingActivityAdapter
            layoutManager = LinearLayoutManager(
                view.context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
        pendingActivities.apply {
            adapter = pendingActivitiesAdapter
            layoutManager = LinearLayoutManager(
                view.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        appliedActivities.apply {
            adapter = appliedActivitiesAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadViewComponents(view)
        initViewModels(view)
        initAdapters(view)

        sessionManager.getUserId()?.let {
            val userId = it
            clientViewModel.getClient(userId, object : ApiCallback<Client> {
                override fun onResponse(result: Response<Client>) {
                    if (result.isSuccessful) {
                        val client = result.body()
                        if (client != null) {
                            onGetClient(client)
                        }
                    }
                }

                override fun onFailure(error: Throwable) {
                    onError(error)
                }

            })
        }
    }

    private fun onGetClient(client: Client) {
        activityViewModel.getPendingClientActivities(
            client.id,
            object : ApiCallback<List<Activity>> {
                override fun onResponse(result: Response<List<Activity>>) {
                    if (result.isSuccessful) {
                        val activities = result.body()
                        if (activities != null) {
                            pendingActivityAdapter.updateData(listOf(activities[0]))
                            pendingActivitiesAdapter.updateData(activities.subList(0, 4))
                        }
                    }
                }

                override fun onFailure(error: Throwable) {
                    onError(error)
                }

            })

        activityViewModel.getAppliedClientActivities(
            client.id,
            object : ApiCallback<List<Activity>> {
                override fun onResponse(result: Response<List<Activity>>) {
                    if (result.isSuccessful) {
                        val appliedActivities = result.body()
                        if (appliedActivities != null) {
                            appliedActivitiesAdapter.updateData(appliedActivities.subList(0, 3))
                        }
                    }
                }

                override fun onFailure(error: Throwable) {
                    onError(error)
                }

            })
    }

    private fun onError(error: Throwable) {
        println(error.message)
    }
}
