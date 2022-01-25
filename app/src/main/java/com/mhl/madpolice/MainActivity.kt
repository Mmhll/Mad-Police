package com.mhl.madpolice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        object : CountDownTimer(3000, 1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                val intent = Intent(this@MainActivity, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()

    }
}