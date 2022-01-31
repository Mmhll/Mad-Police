package com.mhl.madpolice.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhl.madpolice.R
import com.mhl.madpolice.databinding.AboutFragmentBinding

class AboutFragment : Fragment() {

    private lateinit var viewBinding : AboutFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = AboutFragmentBinding.inflate(inflater)
        viewBinding.helloText.text = "Ну привет"
        viewBinding.backButtonAbout.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container_view, MenuFragment())
                ?.commit()
        }
        return viewBinding.root
    }

}