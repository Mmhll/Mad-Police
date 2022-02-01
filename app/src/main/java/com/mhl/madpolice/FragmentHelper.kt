package com.mhl.madpolice

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class FragmentHelper : Fragment() {
    fun setFragment(activity : FragmentActivity, fragmentResource : Int, fragment : Fragment){
        activity.supportFragmentManager?.beginTransaction()
            ?.replace(fragmentResource, fragment)
            ?.commit()
    }
}