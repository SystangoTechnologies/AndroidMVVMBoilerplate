package com.systango.mvvm.data.viewmodel

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.systango.mvvm.common.isValidEmail
import com.systango.mvvm.common.isValidPassword
import com.systango.mvvm.scene.MainActivity
import com.systango.mvvm.scene.splash.SplashActivity

class LogInViewModel : ViewModel() {

    /**
     * Two way bind-able fields
     */
    var username: String = ""
    var password: String = ""

    /**
     * To pass login result to activity
     */
    private val logInResult = MutableLiveData<String>()

    fun getLogInResult(): LiveData<String> = logInResult

    /**
     * Called from activity on login button click
     */




    fun performValidation() {

        if (username.isBlank()) {
            logInResult.value = "Email Required"
            return
        } else if (!username.isValidEmail()) {
            logInResult.value = "Invalid Email"
            return
        }
        if (password.isBlank()) {
            logInResult.value = "Password Required"
            return
        }else if (!password.isValidPassword()) {
            logInResult.value = "Invalid Password"
            return
        }

      logInResult.value = "Sucessfully Login"

    }

}