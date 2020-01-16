package com.systango.mvvm

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.systango.analytics.Analytic
import io.fabric.sdk.android.Fabric


/**
 * Created by Mohit Rajput on 19/9/19.
 */
class MvvmApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        Analytic.init(this)
        Analytic.logEvent("app_launched")
    }
}