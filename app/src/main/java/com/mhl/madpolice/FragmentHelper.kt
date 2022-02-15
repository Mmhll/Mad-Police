package com.mhl.madpolice

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class FragmentHelper(context: Context) : Fragment() {
    fun setFragment(activity : FragmentActivity, fragmentResource : Int, fragment : Fragment){
        activity.supportFragmentManager.beginTransaction()
            .replace(fragmentResource, fragment)
            .commit()
    }
}