package com.systango.mvvm.data.datarepository

import androidx.lifecycle.LiveData
import com.systango.mvvm.data.model.MovieData
import com.systango.mvvm.data.network.ApiClient
import com.systango.mvvm.data.network.DataRepository
import com.systango.mvvm.data.network.DataWrapper
import com.systango.mvvm.data.network.GenericResponse
import retrofit2.Call


class MovieDataRepository : DataRepository<List<MovieData>>() {

    override fun makeRequest(): Call<GenericResponse<List<MovieData>>> {
        // add params and other information here
        return ApiClient.getApiService().movies()
    }

    fun getMovies(): LiveData<DataWrapper> {
        return doRequest()
    }
}