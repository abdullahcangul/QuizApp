package com.example.quizapp

import android.app.Application
import com.facebook.stetho.Stetho

class MyAplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}