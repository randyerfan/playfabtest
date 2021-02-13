package com.randysoft.playfabtest.utils

import android.content.SharedPreferences

class SharedPrefs(private val preferences: SharedPreferences) {
    fun saveToken(token : String){
        preferences.edit().putString(StaticValues.TOKEN_KEY,token).apply()
    }
    fun readToken() = preferences.getString(StaticValues.TOKEN_KEY,"")
}