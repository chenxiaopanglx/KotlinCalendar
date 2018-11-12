package com.example.chy.mykotlin.mvp.presenter

import com.example.chy.mykotlin.api.RetrofitUtil
import com.example.chy.mykotlin.mvp.contract.ICalendarContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Author: chy
 * Date:  2018/11/12
 * Description:
 */

class ICalendarPresenter(val view:ICalendarContract.View) : ICalendarContract.Model {
    override fun getDayCalendarData(data: String) {
        RetrofitUtil.retrofitService
                .calendarDay(data, "933dc930886c8c0717607f9f8bae0b48")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { calendarBean ->
                    view.showDayCalendarData(calendarBean)
                }
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attachView(view: ICalendarContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}