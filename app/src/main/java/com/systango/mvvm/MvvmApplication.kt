package com.systango.mvvm

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric


/**
 * Created by Mohit Rajput on 19/9/19.
 */
class MvvmApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
    }
}