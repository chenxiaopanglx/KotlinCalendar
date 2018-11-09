package com.example.chy.mykotlin.mvp.contract

import com.example.chy.mykotlin.base.IBaseModel
import com.example.chy.mykotlin.base.IBaseView
import com.example.chy.mykotlin.bean.CalentarDayBean

/**
 * Author: chy
 * Date:  2018/11/9
 * Description:
 */
interface ICalendarContract {

    interface View : IBaseView {
        fun showDayCalendarData(calentarDayBean: CalentarDayBean)
        fun showError(errorMsg: String)
    }

    interface Model : IBaseModel<View> {
        fun getDayCalendarData(date: String)
    }
}