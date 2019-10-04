package com.systango.mvvm.fcm

import com.google.firebase.iid.FirebaseInstanceId

class FcmToken {

    /**
     * method to get current firebase fcm token
     */
    fun getCurrentFcmToken(callback: FcmTokeCallback) {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val token = task.result?.token
                    callback.onSuccess(token!!)
                } else {
                    callback.onFailed()
                }
            }
    }

    interface FcmTokeCallback {
        fun onSuccess(token: String)
        fun onFailed()
    }
}