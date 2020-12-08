package com.systango.mvvm.scene.splash

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.systango.mvvm.R
import com.systango.mvvm.data.viewmodel.SplashState
import com.systango.mvvm.data.viewmodel.SplashViewModel
import com.systango.mvvm.scene.MainActivity
import com.systango.mvvm.scene.base.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        splashViewModel.liveData.observe(this, Observer {
            when (it) {
                is SplashState.MainActivity -> {
                    goToMainActivity()
                }
            }
        })
    }

    private fun goToMainActivity() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }
}


//    private lateinit var splashViewModel: SplashViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash)
//
//        initViewModel()
//        observeSplashLiveData()
//    }
//
//    private fun initViewModel() {
//        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
//    }
//
//    private fun observeSplashLiveData() {
//        splashViewModel.initSplashScreen()
//        val observer = Observer<SplashModel> {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//        splashViewModel.liveData.observe(this, observer)
//    }






//fun initfun() {
//    object : CountDownTimer(2000, 500) {
//        override fun onTick(millisUntilFinished: Long) {
//
//        }
//
//        override fun onFinish() {
//            switchToActivity();
//        }
//    }.start()
//}
//
//private fun switchToActivity() {
//    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
//
//}