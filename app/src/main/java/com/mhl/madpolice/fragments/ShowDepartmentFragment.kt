package com.mhl.madpolice.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhl.madpolice.R
import com.mhl.madpolice.apadters.department
import com.mhl.madpolice.apadters.departmentData
import com.mhl.madpolice.databinding.FragmentShowDepartmentBinding
import com.mhl.madpolice.retrofit.MyRetrofit
import com.mhl.madpolice.retrofit.retrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowDepartmentFragment : Fragment() {

    private lateinit var viewBinding : FragmentShowDepartmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentShowDepartmentBinding.inflate(inflater)

        val retrofit = MyRetrofit().retrofit()
        val retrofitApi = retrofit.create(retrofitApi::class.java)
        val prefs = requireActivity().getSharedPreferences("PAGE", Context.MODE_PRIVATE)
        val page = prefs.getString("page", "0")
        val query = retrofitApi.getCurrentDepartment(page!!)
        query.enqueue(object : Callback<department>{
            override fun onResponse(call: Call<department>, response: Response<department>) {
                if (response.isSuccessful){
                    val departmentData : ArrayList<departmentData> = response.body()!!.data
                    viewBinding.textAddress.text = departmentData[0].address
                }
            }

            override fun onFailure(call: Call<department>, t: Throwable) {

            }

        })

        return viewBinding.root
    }

}