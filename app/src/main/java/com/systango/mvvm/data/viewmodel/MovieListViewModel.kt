package com.systango.mvvm.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.systango.mvvm.data.datarepository.MovieDataRepository
import com.systango.mvvm.data.model.MovieData
import com.systango.mvvm.data.network.DataWrapper


class MovieListViewModel : ViewModel() {
    fun getMovies(): LiveData<DataWrapper<List<MovieData>>> {
        return MovieDataRepository().getMovies()
    }
}