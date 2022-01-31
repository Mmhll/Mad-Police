package com.mhl.madpolice.menuActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mhl.madpolice.R
import com.mhl.madpolice.SignInActivity
import com.mhl.madpolice.fragments.AboutFragment
import com.mhl.madpolice.fragments.MenuFragment


class GuestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, MenuFragment())
            .commit()
    }
}