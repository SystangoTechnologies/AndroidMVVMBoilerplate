package com.systango.mvvm.scene.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.systango.mvvm.dagger.DaggerActivityComponent
import com.systango.mvvm.dagger.MovieViewModelModule
import com.systango.mvvm.data.model.MovieData
import com.systango.mvvm.data.network.ApiObserver
import com.systango.mvvm.data.viewmodel.MovieListViewModel
import com.systango.mvvm.databinding.HomeFragmentBinding
import com.systango.mvvm.scene.base.BaseFragment
import com.systango.mvvm.scene.login.LogInActivity
import com.systango.mvvm.utils.Logger
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomeFragment : BaseFragment(), ApiObserver.ChangeListener {
    private lateinit var binding:HomeFragmentBinding
    private var myTag=HomeFragment.javaClass.simpleName
    @set:Inject
    internal var movieListViewModel: MovieListViewModel? = null
    @set:Inject
    lateinit var apiObserver: ApiObserver
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val component =
            DaggerActivityComponent.builder().movieViewModelModule(MovieViewModelModule(this))
                .build()
        component.inject(this)// Initialized the dagger component
        btnApiCall.setOnClickListener {
            movieListViewModel!!.getMovies().observe(this, apiObserver)// api call to get the movies
        }
        btnAuthLogin.setOnClickListener {

            startActivity(Intent(activity, LogInActivity::class.java))




        }
    }

    override fun onPushCalled() {
    }

    override fun onPopCalled() {
    }

    override fun onBackPressed(): Boolean {
        return false// return true if you want to handle the onbackpress in your fragment.
    }

    override fun onFragmentVisibleToUser() {
    }

    override fun onSuccess(dataWrapper: Any) {
        var data= dataWrapper as List<MovieData>?
        Logger.d(myTag, "" + data?.size )
        Log.e("DATA_RESPONSE_SIZE", "" + data?.size)
        Log.e("DATA_RESPONSE", "" + data.toString())
        tvResponse.text = data.toString()
    }

    override fun onException(exception: Exception) {
        Logger.d(myTag, "Exception: $exception" )
    }

    override fun onError(error: String) {
        Logger.d(myTag, "Error : $error" )
    }

}