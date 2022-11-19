package com.example.demo.di

import com.example.demo.ui.fragments.ProductListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: ProductListFragment)
}