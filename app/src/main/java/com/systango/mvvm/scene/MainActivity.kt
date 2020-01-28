package com.systango.mvvm.scene

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.systango.mvvm.R
import com.systango.mvvm.dagger.DaggerActivityComponent
import com.systango.mvvm.dagger.MovieViewModelModule
import com.systango.mvvm.data.model.MovieData
import com.systango.mvvm.data.network.ApiObserver
import com.systango.mvvm.data.viewmodel.MovieListViewModel
import com.systango.sociallogin.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), SocialAuthenticationCallback, View.OnClickListener,
    ApiObserver.ChangeListener<List<MovieData>> {

    @set:Inject
    internal var movieListViewModel: MovieListViewModel? = null
    @set:Inject
    internal var apiObserver: ApiObserver<List<MovieData>>? = null
    private val facebookAuthentication: SocialAuthentication =
        FacebookAuthentication(mutableListOf("email", "public_profile"))
    private val googleAuthentication: SocialAuthentication = GoogleAuthentication()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val activityComponent =
            DaggerActivityComponent.builder().movieViewModelModule(MovieViewModelModule(this))
                .build()
        activityComponent.inject(this)
        fbButton.setOnClickListener(this)
        googleButton.setOnClickListener(this)
        movieListViewModel!!.getMovies().observe(
            this,
            apiObserver!!
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

    override fun onSuccess(data: List<MovieData>) {
        Log.v("DATA", "" + data.size)
    }

    override fun onException(exception: Exception) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
