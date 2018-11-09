package com.example.chy.mykotlin.api

import com.example.chy.mykotlin.constant.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Author: chy
 * Date: 2018/11/8 下午10:16
 * Description:
 */

class RetrofitUtil {
    companion object {
        fun create(url: String): Retrofit {
            val okHttpClientBuilder = OkHttpClient().newBuilder()
            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
        val retrofitService: RetrofitService = RetrofitUtil.getService(Constants.REQUEST_BASE_URL, RetrofitService::class.java)

        fun <T> getService(url: String, service: Class<T>):T {
            return create(url).create(service)
        }
    }
}