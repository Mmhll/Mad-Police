package com.mhl.madpolice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mhl.madpolice.R
import com.mhl.madpolice.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var viewBinding : FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMenuBinding.inflate(inflater)


        viewBinding.aboutButton.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container_view, AboutFragment())
                ?.commit()

        }
        return viewBinding.root
    }
}