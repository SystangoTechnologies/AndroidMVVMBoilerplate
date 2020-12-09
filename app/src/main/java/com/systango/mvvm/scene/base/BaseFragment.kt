package com.systango.mvvm.scene.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.systango.mvvm.scene.MainActivity


/***
 * To utilize the onBackpress and other callback method inside a fragment
 * then have to extend the fragment by the BaseFragment.
 * ****/
open abstract class BaseFragment : Fragment(){

    var backHandlerInterface: BackHandlerInterface? = null
    var mMainActivity : MainActivity? = null
    abstract fun onPushCalled()
    abstract fun onPopCalled()
    abstract fun onBackPressed(): Boolean
    abstract fun onFragmentVisibleToUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (activity !is BackHandlerInterface) {
            throw ClassCastException("Hosting activity must implement BackHandlerInterface")
        } else {
            backHandlerInterface = activity as BackHandlerInterface?
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mMainActivity = activity as MainActivity?
        backHandlerInterface = mMainActivity
    }

    override fun onStart() {
        super.onStart()
         backHandlerInterface?.setSelectedFragment(this)
    }

}