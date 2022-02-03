package com.mhl.madpolice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhl.madpolice.R
import com.mhl.madpolice.databinding.FragmentPaintBinding

class PaintFragment : Fragment() {

    private lateinit var viewBinding : FragmentPaintBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPaintBinding.inflate(inflater)
        viewBinding.backButtonPaint.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container_view, GuestMenuFragment())
                ?.commit()
        }
        return viewBinding.root
    }
}