package com.systango.mvvm.dagger

import com.systango.mvvm.scene.home.HomeFragment
import dagger.Component

@Component(modules = [MovieViewModelModule::class])
interface ActivityComponent {
    fun inject(mainActivity: HomeFragment)
}