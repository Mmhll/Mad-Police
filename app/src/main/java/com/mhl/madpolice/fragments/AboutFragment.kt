package com.mhl.madpolice.fragments

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.mhl.madpolice.FragmentHelper
import com.mhl.madpolice.R
import com.mhl.madpolice.databinding.AboutFragmentBinding

class AboutFragment : Fragment() {

    private lateinit var viewBinding : AboutFragmentBinding
    private lateinit var prefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = AboutFragmentBinding.inflate(inflater)
        viewBinding.helloText.text = "Ну привет"

        prefs = requireActivity().getSharedPreferences("USER", 0)

        viewBinding.backButtonAbout.setOnClickListener {
            if(prefs.getBoolean(getString(R.string.remember), false)) {
                FragmentHelper(requireContext()).setFragment(requireActivity(), R.id.fragment_container_signed, MenuFragment())
            }
            else{
                FragmentHelper(requireContext()).setFragment(requireActivity(), R.id.fragment_container_view, GuestMenuFragment())
            }
        }

        return viewBinding.root
    }

}