package com.example.watchlist

import android.content.Context
import androidx.preference.PreferenceManager

object SharedPrefs {

    private const val LOGIN_STATUS = "LOGIN_STATUS"

    fun sharedPrefs() = PreferenceManager.getDefaultSharedPreferences(MovieApplication.getApplicationContext())

    fun saveLoginStatus(status: Boolean) {
        val editor = sharedPrefs().edit()
        editor.putBoolean(LOGIN_STATUS, status).apply()
    }

    fun clearLoginStatus() {
        sharedPrefs().edit().clear().apply()
    }

    fun status(): Boolean {
        return sharedPrefs().getBoolean(LOGIN_STATUS, false)
    }
}