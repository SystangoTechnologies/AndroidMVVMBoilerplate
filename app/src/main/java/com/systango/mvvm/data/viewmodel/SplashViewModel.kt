package com.systango.mvvm.data.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



class SplashViewModel : ViewModel() {
    val liveData: LiveData<SplashState>
        get() = mutableLiveData
    private val mutableLiveData = MutableLiveData<SplashState>()
    init {
        GlobalScope.launch {
            delay(2000)
            mutableLiveData.postValue(SplashState.MainActivity())
        }
    }
}
sealed class SplashState {
    class MainActivity : SplashState()
}

