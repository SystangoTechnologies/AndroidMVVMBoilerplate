package com.systango.sociallogin

import android.app.Activity
import android.content.Intent
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult

class FacebookAuthentication(private val permissions: List<String>) : SocialAuthentication {
    private lateinit var callback: SocialAuthenticationCallback
    private val callbackManager = CallbackManager.Factory.create()

    override fun login(activity: Activity, callback: SocialAuthenticationCallback) {
        this.callback = callback
        registerLoginManager()
        val currentAccessToken = AccessToken.getCurrentAccessToken()
        val currentProfile = Profile.getCurrentProfile()
        if (currentAccessToken == null)
            LoginManager.getInstance().logInWithReadPermissions(activity, permissions)
        else
            callback.onLoginSuccess(this, getSocialAuthResult(currentAccessToken, currentProfile))
    }

    private fun registerLoginManager() {
        LoginManager.getInstance().registerCallback(callbackManager, object :
            FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                val currentAccessToken = result.accessToken
                val currentProfile = Profile.getCurrentProfile()
                if (currentAccessToken != null)
                    callback.onLoginSuccess(
                        this@FacebookAuthentication,
                        getSocialAuthResult(currentAccessToken, currentProfile)
                    )
            }

            override fun onCancel() {
                callback.onLoginError(
                    this@FacebookAuthentication,
                    SocialAuthError("Facebook login canceled")
                )
            }

            override fun onError(error: FacebookException) {
                callback.onLoginError(
                    this@FacebookAuthentication,
                    SocialAuthError(error.localizedMessage ?: "Facebook login error")
                )
            }

        })
    }

    private fun getSocialAuthResult(accessToken: AccessToken, profile: Profile) =
        SocialAuthResult(
            token = accessToken.token,
            userId = accessToken.userId,
            userName = profile.name
        )

    override fun logout() {
        LoginManager.getInstance().logOut()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}