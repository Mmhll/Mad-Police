package com.mhl.madpolice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhl.madpolice.R
import com.mhl.madpolice.databinding.FragmentPhotorobotBinding


class PhotorobotFragment : Fragment() {

    private lateinit var viewBinding : FragmentPhotorobotBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentPhotorobotBinding.inflate(inflater)

        viewBinding.backButtonRobot.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container_view, MenuFragment())
                ?.commit()
        }


        return viewBinding.root
    }
}