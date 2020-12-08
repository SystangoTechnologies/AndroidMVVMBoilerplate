package com.systango.mvvm.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call


abstract class DataRepository<R> {
    abstract fun makeRequest(): Call<GenericResponse<R>>

    fun doRequest(): LiveData<DataWrapper<R>> {
        val liveData = MutableLiveData<DataWrapper<R>>()
        val dataWrapper = DataWrapper<R>()
        makeRequest().enqueue(object : ApiCallback<R>() {
            override fun handleResponseData(genericResponse: GenericResponse<R>) {
                dataWrapper.data = genericResponse.data
                liveData.value = dataWrapper
            }

            override fun handleError() {
                dataWrapper.error = "Unknown error"
                liveData.value = dataWrapper
            }


            override fun handleException(t: Exception) {
                dataWrapper.apiException = t
                liveData.value = dataWrapper
            }
        })
        return liveData
    }
}