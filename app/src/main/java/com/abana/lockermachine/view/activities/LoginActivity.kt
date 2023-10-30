package com.abana.lockermachine.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.abana.lockermachine.R
import com.abana.lockermachine.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val activity=this;
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        binding.btnLogin.setOnClickListener {
            if(binding.etUsername.text.toString().trim().isNullOrEmpty())
            {
                Toast.makeText(activity,"Please enter user-name",Toast.LENGTH_SHORT).show()
            }
            else if(binding.etPass.text.toString().trim().isNullOrEmpty())
            {
                Toast.makeText(activity,"Please enter password",Toast.LENGTH_SHORT).show()
            }
            else if(!binding.etUsername.text.toString().trim().equals("user123") && !binding.etPass.text.toString().trim().equals(123456))
            {
                Toast.makeText(activity,"Invalid Credentials",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(activity,"Login successfully",Toast.LENGTH_SHORT).show()
                startActivity(Intent(activity,MainActivity::class.java))
                finish()
            }
        }
    }
}