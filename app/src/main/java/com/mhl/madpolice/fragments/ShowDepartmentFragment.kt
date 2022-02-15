package com.mhl.madpolice.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhl.madpolice.apadters.Department
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
        val page = prefs.getString("page", "1")
        val query = retrofitApi.getCurrentDepartment(page!!)
        query.enqueue(object : Callback<Department>{
            override fun onResponse(call: Call<Department>, response: Response<Department>) {
                if (response.isSuccessful){
                    response.body()!!.data.let {
                        viewBinding.textAddress.text = it[0].address
                        viewBinding.textBoss.text = it[0].boss
                        viewBinding.textDescription.text = it[0].description
                        viewBinding.textEmail.text = it[0].email
                        viewBinding.textName.text = it[0].name
                        viewBinding.textPhone.text = it[0].phone
                        Log.d("yes", "success")
                    }
                }
            }

            override fun onFailure(call: Call<Department>, t: Throwable) {

            }

        })

        return viewBinding.root
    }

}