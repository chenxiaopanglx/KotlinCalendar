package com.example.chy.mykotlin.mvp.contract

import com.example.chy.mykotlin.base.IBaseModel
import com.example.chy.mykotlin.base.IBaseView
import com.example.chy.mykotlin.bean.CalendarDayBean

/**
 * Author: chy
 * Date:  2018/11/12
 * Description:
 */
interface ICalendarContract{
    interface View : IBaseView{
        fun showDayCalendarData(calendatBean: CalendarDayBean)
    }

    interface Model : IBaseModel<ICalendarContract.View> {
        fun getDayCalendarData(data : String)
    }
}