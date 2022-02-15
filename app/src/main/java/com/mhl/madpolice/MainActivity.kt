package com.mhl.madpolice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.mhl.madpolice.menuActivity.SignedActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        object : CountDownTimer(2000, 1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                val prefs = getSharedPreferences("USER", MODE_PRIVATE)
                if (prefs.getString(getString(R.string.id), "") == null || prefs.getString(getString(R.string.id), "").equals("")) {
                    startActivity(Intent(this@MainActivity, SignInActivity::class.java))
                    finish()
                }
                else{
                    startActivity(Intent(this@MainActivity, SignedActivity::class.java))
                    finish()
                }

            }
        }.start()

    }
}