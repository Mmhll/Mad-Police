package com.mhl.madpolice.menuActivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mhl.madpolice.FragmentHelper
import com.mhl.madpolice.R
import com.mhl.madpolice.fragments.MenuFragment

class SignedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signed)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_signed, MenuFragment())
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        val prefs = getSharedPreferences("USER", MODE_PRIVATE)
        if (!prefs.getBoolean(getString(R.string.remember), false)){
            getSharedPreferences("USER", Context.MODE_PRIVATE)?.edit()?.clear()?.apply()
        }
    }
}