package com.mhl.madpolice.menuActivity

import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mhl.madpolice.FragmentHelper
import com.mhl.madpolice.R
import com.mhl.madpolice.databinding.ActivityGuestBinding
import com.mhl.madpolice.fragments.GuestMenuFragment


class GuestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, GuestMenuFragment())
            .commit()
    }


}