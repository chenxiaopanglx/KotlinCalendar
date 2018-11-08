package com.example.chy.mykotlin

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import com.example.chy.mykotlin.api.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectBtn.setOnClickListener {
            selectBtn.visibility = View.GONE
            detail.visibility = View.GONE
            dataPicker.visibility = View.VISIBLE
        }

        dataPicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            dataPicker.visibility = View.GONE
            detail.visibility = View.VISIBLE
            selectBtn.visibility = View.GONE

            RetrofitUtil.retrofitService
                    .calendarDay("$year-$monthOfYear-$dayOfMonth","933dc930886c8c0717607f9f8bae0b48")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { calendarDayBean ->
                        detail.text = calendarDayBean.toString()
                    }
        }
    }
}
