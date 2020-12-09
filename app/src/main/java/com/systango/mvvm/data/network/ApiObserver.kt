package com.systango.mvvm.data.network

import androidx.lifecycle.Observer


open class ApiObserver (private val changeListener: ChangeListener) :
    Observer<DataWrapper > {
    override fun onChanged(tDataWrapper: DataWrapper?) {
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

    interface ChangeListener {
        fun onSuccess(dataWrapper: Any)
        fun onException(exception: Exception)
        fun onError(error: String)
    }
}