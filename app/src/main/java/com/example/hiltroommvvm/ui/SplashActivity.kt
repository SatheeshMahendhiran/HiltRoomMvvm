package com.example.hiltroommvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.hiltroommvvm.R
import com.example.hiltroommvvm.ui.signin.SignInActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            runOnUiThread {

                startActivity(Intent(this, SignInActivity::class.java))

                finish()
            }
        }, 1000)

    }

}