package com.example.hiltroommvvm.application

import android.app.Application
import com.example.hiltroommvvm.data.preference.AppPreference
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppPreference.initAppPreference(this)

    }

}