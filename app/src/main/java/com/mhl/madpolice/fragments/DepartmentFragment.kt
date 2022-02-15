package com.mhl.madpolice.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mhl.madpolice.FragmentHelper
import com.mhl.madpolice.R
import com.mhl.madpolice.apadters.Department
import com.mhl.madpolice.databinding.FragmentDepartmentBinding
import com.mhl.madpolice.recycleradapters.DepartmentRecyclerAdapter
import com.mhl.madpolice.retrofit.MyRetrofit
import com.mhl.madpolice.retrofit.retrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DepartmentFragment : Fragment() {

    private lateinit var viewBinding : FragmentDepartmentBinding
    private lateinit var prefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDepartmentBinding.inflate(inflater)
        prefs = requireActivity().getSharedPreferences("USER", 0)


        var retrofit = MyRetrofit().retrofit()
        var api = retrofit.create(retrofitApi::class.java)
        api.getDepartment().enqueue(object : Callback<Department>{
            override fun onResponse(call: Call<Department>, response: Response<Department>) {
                if (response.isSuccessful){
                    response.body()!!.let {
                        var adapter = DepartmentRecyclerAdapter(it, requireContext())
                        adapter.setOnItemClickListener(object : DepartmentRecyclerAdapter.onItemClickListener{
                            override fun onItemClick(position: Int) {
                                val prefs = requireActivity().getSharedPreferences("PAGE", Context.MODE_PRIVATE)
                                prefs.edit().putString("page", position.toString()).apply()
                                if (prefs.getBoolean(getString(R.string.remember), false)){
                                    FragmentHelper(requireContext()).setFragment(
                                            requireActivity(),
                                            R.id.fragment_container_view,
                                            ShowDepartmentFragment()
                                        )
                                }
                                else{
                                    FragmentHelper(requireContext()).setFragment(
                                            requireActivity(),
                                            R.id.fragment_container_signed,
                                            ShowDepartmentFragment()
                                        )
                                }

                            }

                        })
                        viewBinding.departmentsRecycler.adapter = adapter

                    }
                }
            }

            override fun onFailure(call: Call<Department>, t: Throwable) {
            }

        })

        viewBinding.backButtonMain.setOnClickListener {
            if (prefs.getBoolean(getString(R.string.remember), false)) {
                FragmentHelper(requireContext()).setFragment(
                    requireActivity(),
                    R.id.fragment_container_signed,
                    GuestMenuFragment()
                )
            }
            else {
                FragmentHelper(requireContext()).setFragment(
                    requireActivity(),
                    R.id.fragment_container_view,
                    GuestMenuFragment()
                )
            }
        }




        return viewBinding.root
    }
}