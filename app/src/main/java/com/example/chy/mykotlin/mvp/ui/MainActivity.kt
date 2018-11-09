package com.example.chy.mykotlin.mvp.ui

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import com.example.chy.mykotlin.R
import com.example.chy.mykotlin.bean.CalentarDayBean
import com.example.chy.mykotlin.mvp.contract.ICalendarContract
import com.example.chy.mykotlin.mvp.presenter.CalendarDatePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ICalendarContract.View {

    lateinit var presenter: CalendarDatePresenter
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = CalendarDatePresenter(this)

        selectBtn.setOnClickListener {
            selectBtn.visibility = View.GONE
            detail.visibility = View.GONE
            dataPicker.visibility = View.VISIBLE
        }

        dataPicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            dataPicker.visibility = View.GONE
            detail.visibility = View.VISIBLE
            selectBtn.visibility = View.GONE
            presenter.getDayCalendarData("$year-$monthOfYear-$dayOfMonth")
        }
    }

    override fun showDayCalendarData(calentarDayBean: CalentarDayBean) {
        dataPicker.visibility = View.GONE
        detail.visibility = View.VISIBLE
        selectBtn.visibility = View.VISIBLE
        detail.text = calentarDayBean.result.data.weekday
     }

    override fun showError(errorMsg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun killMySelf() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
