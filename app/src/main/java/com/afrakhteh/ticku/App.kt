package com.afrakhteh.ticku

import android.app.Application
import com.afrakhteh.ticku.di.builders.ApplicationComponentBuilder

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationComponentBuilder.app = this
    }
}