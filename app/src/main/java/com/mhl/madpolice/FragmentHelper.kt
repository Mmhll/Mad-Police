package com.mhl.madpolice

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class FragmentHelper : Fragment() {

    fun getPrefs(activity : FragmentActivity) : Boolean{
        var prefs = activity.getSharedPreferences("USER", Context.MODE_PRIVATE)
        if (prefs.getString(getString(R.string.id), "")!! == ""){
            return false
        }
        return true
    }

    fun setFragment(activity : FragmentActivity, fragmentResource : Int, fragment : Fragment){
        activity.supportFragmentManager.beginTransaction()
            .replace(fragmentResource, fragment)
            .commit()
    }

    fun clearPreferences(){
        activity?.getSharedPreferences("USER", Context.MODE_PRIVATE)?.edit()?.clear()?.apply()
    }
}