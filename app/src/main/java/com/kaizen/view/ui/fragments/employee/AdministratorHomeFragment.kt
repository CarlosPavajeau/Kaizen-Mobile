package com.kaizen.view.ui.fragments.employee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaizen.R
import com.kaizen.model.activityschedule.Activity
import com.kaizen.model.invoice.service.ServiceInvoice
import com.kaizen.model.statistics.DayStatistics
import com.kaizen.network.ApiCallback
import com.kaizen.view.adapter.InvoiceAdapter
import com.kaizen.view.adapter.LastClientAdapter
import com.kaizen.view.adapter.TapListener
import com.kaizen.viewmodel.ActivityViewModel
import com.kaizen.viewmodel.ServiceInvoiceViewModel
import com.kaizen.viewmodel.StatisticsViewModel
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [AdministratorHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdministratorHomeFragment : Fragment(), TapListener<Activity> {
    lateinit var statisticsViewModel: StatisticsViewModel
    lateinit var activityViewModel: ActivityViewModel
    lateinit var serviceInvoiceViewModel: ServiceInvoiceViewModel

    lateinit var lastClientAdapter: LastClientAdapter
    lateinit var invoiceAdapter: InvoiceAdapter

    lateinit var todayAppliedStatistics: TextView
    lateinit var lastVisitedClients: RecyclerView
    lateinit var generatedInvoices: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_administrator_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        todayAppliedStatistics = view.findViewById(R.id.tv_today_applied_activities)
        lastVisitedClients = view.findViewById(R.id.rv_last_visited_clients)
        generatedInvoices = view.findViewById(R.id.rv_generated_invoices)

        statisticsViewModel = StatisticsViewModel(view.context)
        activityViewModel = ActivityViewModel(view.context)
        serviceInvoiceViewModel = ServiceInvoiceViewModel(view.context)

        lastClientAdapter = LastClientAdapter(this)
        lastVisitedClients.apply {
            adapter = lastClientAdapter
            layoutManager =
                LinearLayoutManager(
                    view.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
        }

        invoiceAdapter = InvoiceAdapter(object : TapListener<ServiceInvoice> {
            override fun onTap(data: ServiceInvoice) {
                println(data)
            }

        })
        generatedInvoices.apply {
            adapter = invoiceAdapter
            layoutManager =
                LinearLayoutManager(
                    view.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }


        statisticsViewModel.currentDay(object : ApiCallback<DayStatistics> {
            override fun onResponse(result: Response<DayStatistics>) {
                if (result.isSuccessful) {
                    val dayStatistics = result.body()
                    if (dayStatistics != null) {
                        todayAppliedStatistics.text = dayStatistics.appliedActivities.toString()
                    }
                }
            }

            override fun onFailure(error: Throwable) {
                println("Error statistics: $error")
            }

        })

        activityViewModel.getActivities(object : ApiCallback<List<Activity>> {
            override fun onResponse(result: Response<List<Activity>>) {
                if (result.isSuccessful) {
                    val activities = result.body()
                    if (activities != null) {
                        lastClientAdapter.updateData(activities)
                    }
                }
            }

            override fun onFailure(error: Throwable) {
                println("Error activities: $error")
            }

        })

        serviceInvoiceViewModel.getServiceInvoices(object : ApiCallback<List<ServiceInvoice>> {
            override fun onResponse(result: Response<List<ServiceInvoice>>) {
                if (result.isSuccessful) {
                    val invoices = result.body()
                    if (invoices != null) {
                        invoiceAdapter.updateData(invoices)
                    }
                }
            }

            override fun onFailure(error: Throwable) {
                println("Invoices error: $error")
            }

        })
    }

    override fun onTap(data: Activity) {
        findNavController().navigate(
            R.id.activity_detail_fragment,
            bundleOf("activity" to data.code)
        )
    }
}
