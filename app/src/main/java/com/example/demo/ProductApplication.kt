package com.example.demo

import android.app.Application
import com.example.demo.di.ApplicationComponent
import com.example.demo.di.DaggerApplicationComponent

class ProductApplication : Application() {
      lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()

    }
}