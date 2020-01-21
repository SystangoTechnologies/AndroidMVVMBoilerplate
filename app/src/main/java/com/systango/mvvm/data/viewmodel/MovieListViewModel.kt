package com.systango.mvvm.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.systango.mvvm.data.datarepository.MovieDataRepository
import com.systango.mvvm.data.model.MovieResponseModel


class MovieListViewModel : ViewModel() {
    private lateinit var movieLiveData: MutableLiveData<MovieResponseModel>

    fun init() {
        movieLiveData = MovieDataRepository.getMovies()
    }

    fun getMoveLiveData(): MutableLiveData<MovieResponseModel> {
        return movieLiveData
    }

}