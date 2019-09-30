package com.systango.sociallogin

import android.app.Activity
import android.content.Intent

interface SocialAuthentication {
    fun login(activity: Activity, callback: SocialAuthenticationCallback)

    fun logout()

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
}