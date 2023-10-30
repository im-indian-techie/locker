package com.abana.lockermachine.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.abana.lockermachine.R

class SplashActivity : AppCompatActivity() {
    val activity=this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startActivity(Intent(activity, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            finish()

        }, 2000)
    }
}