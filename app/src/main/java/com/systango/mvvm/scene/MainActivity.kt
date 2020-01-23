package com.systango.mvvm.scene

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.systango.mvvm.R
import com.systango.mvvm.data.model.MovieData
import com.systango.mvvm.data.network.ApiObserver
import com.systango.mvvm.data.viewmodel.MovieListViewModel
import com.systango.sociallogin.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SocialAuthenticationCallback, View.OnClickListener {
    private val facebookAuthentication: SocialAuthentication =
        FacebookAuthentication(mutableListOf("email", "public_profile"))
    private val googleAuthentication: SocialAuthentication = GoogleAuthentication()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fbButton.setOnClickListener(this)
        googleButton.setOnClickListener(this)
        val vieModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)
        val listener = object : ApiObserver.ChangeListener<List<MovieData>> {
            override fun onSuccess(dataWrapper: List<MovieData>) {
                Log.v("DATA", "" + dataWrapper.size)
            }

            override fun onException(exception: Exception) {
            }

            override fun onError(error: String) {
            }

        }
        vieModel.getMovies().observe(
            this,
            ApiObserver(listener)
        )

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
