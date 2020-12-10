package com.systango.mvvm.data.network

import com.google.gson.GsonBuilder
import com.systango.mvvm.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit


object ApiClient {

    private var retrofit: Retrofit? = null
    var ADD_LOG = BuildConfig.DEBUG

    // <-- this is the important line!
    fun getApiService(): ApiInterface {
        if (retrofit == null) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
            httpClient.connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
            if (ADD_LOG)
                httpClient.addInterceptor(logging)
            val gson = GsonBuilder()
                .setLenient()
                .create()
            retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build()

        }
        return retrofit?.create(ApiInterface::class.java)!!
    }
}
