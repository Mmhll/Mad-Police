package com.mhl.madpolice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhl.madpolice.FragmentHelper
import com.mhl.madpolice.R
import com.mhl.madpolice.apadters.Wanted
import com.mhl.madpolice.databinding.FragmentWantedBinding
import com.mhl.madpolice.recycleradapters.WantedRecyclerAdapter
import com.mhl.madpolice.retrofit.MyRetrofit
import com.mhl.madpolice.retrofit.retrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WantedFragment : Fragment() {

    private lateinit var binding : FragmentWantedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWantedBinding.inflate(inflater)


        val retrofit = MyRetrofit().retrofit()
        val api = retrofit.create(retrofitApi::class.java)
        api.getWanted().enqueue(object : Callback<Wanted>{
            override fun onResponse(call: Call<Wanted>, response: Response<Wanted>) {
                if (response.isSuccessful){
                    response.body()!!.let {
                        val adapter = WantedRecyclerAdapter(it, requireContext())
                        adapter.setOnItemClickListener(object : WantedRecyclerAdapter.onItemClickListener{
                            override fun onItemClick(position: Int) {
                                FragmentHelper(requireContext()).setFragment(requireActivity(), R.id.fragment_container_signed, ShowWantedFragment())
                            }
                        })
                        binding.wantedRecycler.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<Wanted>, t: Throwable) {

            }

        })

        return binding.root
    }
}