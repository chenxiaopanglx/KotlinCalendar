package com.example.chy.mykotlin.api

import com.example.chy.mykotlin.bean.CalentarDayBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Author: chy
 * Date: 2018/11/8 下午9:57
 * Description:
 */
interface RetrofitService {

    @GET("calendar/day")
    fun calendarDay(
            @Query("date") date: String,
            @Query("key") key: String
    ): Observable<CalentarDayBean>
}