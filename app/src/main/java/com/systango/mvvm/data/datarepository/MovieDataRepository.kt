package com.systango.mvvm.data.datarepository

import androidx.lifecycle.MutableLiveData
import com.systango.mvvm.data.model.MovieResponseModel
import com.systango.mvvm.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object MovieDataRepository {

    fun getMovies(): MutableLiveData<MovieResponseModel> {
        val data = MutableLiveData<MovieResponseModel>()
        val apiService = ApiClient.getApiService()
        apiService.movies().enqueue(object : Callback<MovieResponseModel> {
            override fun onFailure(call: Call<MovieResponseModel>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<MovieResponseModel>,
                response: Response<MovieResponseModel>
            ) {
                data.value = response.body()
            }

        })
        return data
    }
}