package com.kaizen.network.service

import android.content.Context
import com.kaizen.model.statistics.DayStatistics
import com.kaizen.model.statistics.MonthStatistics
import com.kaizen.model.statistics.YearStatistics
import com.kaizen.network.ApiCallback
import com.kaizen.network.ApiServiceBuilder
import com.kaizen.network.Callback
import com.kaizen.network.api.StatisticsAPI

class StatisticsService(context: Context) {
    private val statisticsApi =
        ApiServiceBuilder.buildApiService(StatisticsAPI::class.java, context)

    fun currentYear(apiCallback: ApiCallback<YearStatistics>) {
        statisticsApi.currentYear().enqueue(Callback(apiCallback))
    }

    fun currentMonth(apiCallback: ApiCallback<MonthStatistics>) {
        statisticsApi.currentMonth().enqueue(Callback(apiCallback))
    }

    fun currentDay(apiCallback: ApiCallback<DayStatistics>) {
        statisticsApi.currentDay().enqueue(Callback(apiCallback))
    }
}
