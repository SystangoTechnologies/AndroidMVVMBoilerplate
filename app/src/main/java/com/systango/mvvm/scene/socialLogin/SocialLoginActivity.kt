package com.systango.mvvm.scene.socialLogin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.systango.mvvm.R
import com.systango.sociallogin.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_social_login.*

class SocialLoginActivity : AppCompatActivity(), SocialAuthenticationCallback, View.OnClickListener {
    private val facebookAuthentication: SocialAuthentication =
        FacebookAuthentication(mutableListOf("email", "public_profile"))
    private val googleAuthentication: SocialAuthentication = GoogleAuthentication()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_login)
        fbButton.setOnClickListener(this)
        googleButton.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == GoogleAuthentication.REQ_CODE)
            googleAuthentication.onActivityResult(requestCode, resultCode, data)
        else
            facebookAuthentication.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onLoginSuccess(
        socialAuthentication: SocialAuthentication,
        autnResult: SocialAuthResult
    ) {
        if (socialAuthentication is FacebookAuthentication) {
            // Facebook Auth result
        } else {
            // Google Auth result
        }
    }

    override fun onLoginError(socialAuthentication: SocialAuthentication, error: SocialAuthError) {
        if (socialAuthentication is FacebookAuthentication) {
            // Facebook Auth error
        } else {
            // Google Auth error
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.fbButton -> facebookAuthentication.login(this, this)
            R.id.googleButton -> googleAuthentication.login(this, this)
        }
    }
}
