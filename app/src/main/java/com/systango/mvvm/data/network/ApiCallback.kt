package com.systango.mvvm.data.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


abstract class ApiCallback<T> : Callback<GenericResponse<T>> {

    override fun onResponse(
        call: Call<GenericResponse<T>>,
        response: Response<GenericResponse<T>>
    ) {
        if (response.body() != null) {
            if (response.isSuccessful)
                handleResponseData(response.body()!!)
            else
                handleError()
        }
    }

    override fun onFailure(call: Call<GenericResponse<T>>, t: Throwable) {
        if (t is Exception) {
            handleException(t)
        } else {
            handleError()
        }
    }

    protected abstract fun handleResponseData(genericResponse: GenericResponse<T>)

    protected abstract fun handleError()

    protected abstract fun handleException(t: Exception)
}