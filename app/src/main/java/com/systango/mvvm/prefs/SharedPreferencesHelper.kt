package com.systango.mvvm.prefs

import android.content.SharedPreferences

class SharedPreferencesHelper(private val sharedPreferences: SharedPreferences) {

    companion object {
        internal val KEY_IS_LOGGED_IN = "is_logged_in"
    }

    fun setLoggedIn(loggedIn: Boolean) {
        val editor = sharedPreferences.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, loggedIn)
        }
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }

}