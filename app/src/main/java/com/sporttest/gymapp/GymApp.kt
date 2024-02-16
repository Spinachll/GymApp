package com.sporttest.gymapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GymApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
