package com.example.chy.mykotlin.base

/**
 * Author: chy
 * Date:  2018/11/9
 * Description:
 */
interface IBaseModel<T> {
    fun onDestroy()
    fun attachView(view: T)
}