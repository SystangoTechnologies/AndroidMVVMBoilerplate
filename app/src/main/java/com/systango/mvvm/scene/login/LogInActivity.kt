package com.systango.mvvm.scene.login


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.systango.mvvm.R
import com.systango.mvvm.data.viewmodel.LogInViewModel
import com.systango.mvvm.databinding.ActivityLoginBinding
import com.systango.mvvm.scene.MainActivity

class LogInActivity : AppCompatActivity(), LogInHandler {

    private lateinit var viewModel: LogInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Binding
        val binding=DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        // ViewModel
        this.viewModel = ViewModelProviders.of(this).get(LogInViewModel::class.java)
        // Setting binding params
        binding.viewModel = viewModel
        binding.handler = this
        // Watching for login result
        viewModel.getLogInResult().observe(this, Observer { result ->
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            if (result.equals("Sucessfully Login")) {
                goToMainActivity()

            }


        })
    }

    private fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onLogInClicked() {
        viewModel.performValidation()


    }

}