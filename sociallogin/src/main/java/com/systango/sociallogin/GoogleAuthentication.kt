package com.systango.sociallogin

import android.app.Activity
import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class GoogleAuthentication : SocialAuthentication {
    companion object{
        const val REQ_CODE: Int = 11
    }
    private lateinit var callback: SocialAuthenticationCallback
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun login(activity: Activity, callback: SocialAuthenticationCallback) {
        this.callback = callback
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(activity, gso)
        val signInIntent = googleSignInClient.signInIntent
        activity.startActivityForResult(signInIntent, REQ_CODE)
    }

    override fun logout() {
        googleSignInClient.signOut()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        handleSignInResult(task)
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            callback.onLoginSuccess(this, getSocialAuthResult(account))
        } catch (e: ApiException) {
            Log.v("APIEXCEPTION", e.statusCode.toString() + ", " + e.cause + e.message)
            callback.onLoginError(this, SocialAuthError("Google login failed"))
        }

    }

    private fun getSocialAuthResult(googleSignInAccount: GoogleSignInAccount?) =
        SocialAuthResult(
            token = googleSignInAccount?.idToken ?: "",
            userId = googleSignInAccount?.id ?: "",
            userName = googleSignInAccount?.displayName ?: "",
            email = googleSignInAccount?.email ?: ""
        )
}