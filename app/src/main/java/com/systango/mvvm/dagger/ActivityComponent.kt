package com.systango.mvvm.dagger

import com.systango.mvvm.scene.MainActivity
import dagger.Component

@Component(modules = [MovieViewModelModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}