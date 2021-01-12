package com.systango.mvvm.scene

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.systango.mvvm.R
import com.systango.mvvm.scene.base.BackHandlerInterface
import com.systango.mvvm.scene.base.BaseActivity
import com.systango.mvvm.scene.base.BaseFragment
import com.systango.mvvm.scene.home.HomeFragment
import com.systango.mvvm.utils.AppConstant
import com.systango.mvvm.utils.FragmentHelper

class MainActivity : BaseActivity(), BackHandlerInterface {
    var fragmentCount: Int = AppConstant.BACK_STACK_COUNT_VALUE
    lateinit var baseFragment: BaseFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        openHomeFragment()
        supportFragmentManager.addOnBackStackChangedListener(getListener())

    }


    override fun setSelectedFragment(backHandledFragment: BaseFragment) {
        baseFragment = backHandledFragment
    }

    private fun getListener(): FragmentManager.OnBackStackChangedListener {
        return object : FragmentManager.OnBackStackChangedListener {
            override fun onBackStackChanged() {
                val manager = supportFragmentManager
                if (manager != null) {
                    val backStackEntryCount = manager.backStackEntryCount
                    if (backStackEntryCount > AppConstant.BACK_STACK_COUNT_VALUE) {
                        val backStackEntry = manager.getBackStackEntryAt(backStackEntryCount - 1)
                        val fragmentTag = backStackEntry.name
                        if (null != manager.findFragmentByTag(fragmentTag)) {
                            baseFragment = manager.findFragmentByTag(fragmentTag) as BaseFragment
                        }
                        if (baseFragment == null) return
                        if (null != baseFragment)
                            baseFragment.onFragmentVisibleToUser()

                        if (backStackEntryCount > fragmentCount) {
                            fragmentCount = backStackEntryCount
                            if (null != baseFragment)
                                baseFragment.onPushCalled()

                        } else if (backStackEntryCount < fragmentCount) {
                            fragmentCount = backStackEntryCount
                            if (null != baseFragment)
                                baseFragment.onPopCalled()
                        }
                    }
                }
            }
        }
    }


    override fun onBackPressed() {
        if (!this::baseFragment.isInitialized || !baseFragment.onBackPressed()) {
            // Selected fragment did not consume the back press event.
            val fm = supportFragmentManager
            val count = fm.backStackEntryCount
            if (count > AppConstant.BACK_STACK_COUNT_VALUE) {
                fm.popBackStack()
            } else {
                fm.popBackStack()
                super.onBackPressed()
            }
        }
    }

    private fun openHomeFragment(){
        FragmentHelper.addAndInitFragment(HomeFragment.newInstance(),R.id.fragment_container, supportFragmentManager)
    }
}
