package com.systango.mvvm.data.network

import androidx.lifecycle.Observer


open class ApiObserver<T>(private val changeListener: ChangeListener<T>) : Observer<DataWrapper<T>> {
    override fun onChanged(tDataWrapper: DataWrapper<T>?) {
        if (tDataWrapper != null) {
            if (tDataWrapper.data != null) {
                changeListener.onSuccess(tDataWrapper.data!!)
            } else if (tDataWrapper.apiException != null) {
                changeListener.onException(tDataWrapper.apiException!!)
            } else if (tDataWrapper.error != null) {
                changeListener.onError(tDataWrapper.error!!)
            }
            return
        }
        changeListener.onError("Unknown error")
    }

    interface ChangeListener<T> {
        fun onSuccess(dataWrapper: T)
        fun onException(exception: Exception)
        fun onError(error: String)
    }
}