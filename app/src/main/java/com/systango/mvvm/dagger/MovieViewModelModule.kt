package com.systango.mvvm.dagger

import androidx.lifecycle.ViewModelProviders
import com.systango.mvvm.data.datarepository.MovieDataRepository
import com.systango.mvvm.data.model.MovieData
import com.systango.mvvm.data.network.ApiObserver
import com.systango.mvvm.data.viewmodel.MovieListViewModel
import com.systango.mvvm.scene.MainActivity
import com.systango.mvvm.scene.home.HomeFragment
import dagger.Module
import dagger.Provides

@Module
class MovieViewModelModule(private val activity: HomeFragment) {
    @Provides
    fun provideViewModel(): MovieListViewModel {
        val movieListViewModel = ViewModelProviders.of(activity).get(MovieListViewModel::class.java)
        movieListViewModel.repository=MovieDataRepository()
        return ViewModelProviders.of(activity).get(MovieListViewModel::class.java)
    }

    @Provides
    fun provideApiObserver(): ApiObserver {
        return ApiObserver(activity)
    }
}