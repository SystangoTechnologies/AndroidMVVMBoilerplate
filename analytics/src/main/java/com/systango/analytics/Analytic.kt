package com.systango.analytics

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object Analytic {
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    fun init(context: Context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }


    fun logEvent(eventName: String) {
        firebaseAnalytics.logEvent(eventName, null)
    }

    fun logEvent(eventName: String, eventProperties: Bundle) {
        firebaseAnalytics.logEvent(eventName, eventProperties)
    }

    fun logScreen(activity: Activity, screenName: String) {
        firebaseAnalytics.setCurrentScreen(activity, screenName, null)
    }

    fun setUserId(userId: String) {
        firebaseAnalytics.setUserId(userId)
    }
}