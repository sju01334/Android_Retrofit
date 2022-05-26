package com.nepplus.android_retrofit.utils

import android.content.Context

class ContextUtil {

    companion object{
        private val prefName = "RetrofitPref"

        private val AUTO_LOGIN = "AUTO_LOGIN"
        private val LOGIN_TOKEN = "LOGIN_TOKEN"

        fun setLoginToken(context : Context, token : String){
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putString(LOGIN_TOKEN, token).apply()
        }

        fun getLoginToken(context: Context) : String {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getString(LOGIN_TOKEN, "")!!
        }



    }
}