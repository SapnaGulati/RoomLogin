package com.riskpace.demo.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.riskpace.demo.NavigationActivity
import com.riskpace.demo.ui.authentication.SignInActivity
import com.riskpace.demo.viewmodel.AuthenticationViewModel


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)
        if (viewModel.isLogOut())
            startActivity(Intent(this, NavigationActivity::class.java))
        else
            startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }
}