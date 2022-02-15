package com.mhl.madpolice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhl.madpolice.R
import com.mhl.madpolice.databinding.FragmentShowWantedBinding

class ShowWantedFragment : Fragment() {

    private lateinit var binding : FragmentShowWantedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowWantedBinding.inflate(inflater)


        return binding.root
    }
}