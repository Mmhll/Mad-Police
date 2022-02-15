package com.mhl.madpolice.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhl.madpolice.FragmentHelper
import com.mhl.madpolice.R
import com.mhl.madpolice.SignInActivity
import com.mhl.madpolice.databinding.FragmentMenu2Binding

class MenuFragment : Fragment() {

    private lateinit var binding : FragmentMenu2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMenu2Binding.inflate(inflater)

        binding.departmentsButton.setOnClickListener {
            FragmentHelper(requireContext()).setFragment(requireActivity(), R.id.fragment_container_signed, DepartmentFragment())
        }

        binding.aboutButton.setOnClickListener {
            FragmentHelper(requireContext()).setFragment(requireActivity(), R.id.fragment_container_signed, AboutFragment())
        }

        binding.logoutButton.setOnClickListener {
            startActivity(Intent(requireContext(), SignInActivity::class.java))
            val prefs = requireContext().getSharedPreferences("USER", 0)
            prefs.edit().clear().apply()
            requireActivity().finish()
        }

        binding.wantedButton.setOnClickListener {
            FragmentHelper(requireContext()).setFragment(requireActivity(), R.id.fragment_container_signed, WantedFragment())
        }

        return binding.root
    }
}