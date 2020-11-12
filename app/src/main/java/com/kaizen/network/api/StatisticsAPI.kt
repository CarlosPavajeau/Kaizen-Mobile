package com.kaizen.network.api

import com.kaizen.model.statistics.DayStatistics
import com.kaizen.model.statistics.MonthStatistics
import com.kaizen.model.statistics.YearStatistics
import com.kaizen.network.ApiUrls.STATISTICS_API_URL
import retrofit2.Call
import retrofit2.http.GET

interface StatisticsAPI {
    @GET("$STATISTICS_API_URL/CurrentYear")
    fun currentYear(): Call<YearStatistics>

    @GET("$STATISTICS_API_URL/CurrentMonth")
    fun currentMonth(): Call<MonthStatistics>

    @GET("$STATISTICS_API_URL/CurrentDay")
    fun currentDay(): Call<DayStatistics>
}
