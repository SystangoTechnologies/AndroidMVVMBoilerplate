package com.systango.mvvm.data.network

import com.systango.mvvm.data.model.MovieData
import com.systango.mvvm.data.model.MovieResponseModel
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("list.json")
    fun movies(): Call<GenericResponse<List<MovieData>>>

}
