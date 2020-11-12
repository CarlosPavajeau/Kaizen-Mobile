package com.kaizen.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kaizen.model.statistics.DayStatistics
import com.kaizen.model.statistics.MonthStatistics
import com.kaizen.model.statistics.YearStatistics
import com.kaizen.network.ApiCallback
import com.kaizen.network.service.StatisticsService

class StatisticsViewModel(context: Context) : ViewModel() {
    private val statisticsService = StatisticsService(context)

    fun currentYear(apiCallback: ApiCallback<YearStatistics>) {
        statisticsService.currentYear(apiCallback)
    }

    fun currentMonth(apiCallback: ApiCallback<MonthStatistics>) {
        statisticsService.currentMonth(apiCallback)
    }

    fun currentDay(apiCallback: ApiCallback<DayStatistics>) {
        statisticsService.currentDay(apiCallback)
    }
}
