package com.systango.mvvm.data.network


class DataWrapper<T> {
    var apiException: Exception? = null
    var data: T? = null
    var error: String? = null
}