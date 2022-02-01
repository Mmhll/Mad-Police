package com.mhl.madpolice.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhl.madpolice.R
import com.mhl.madpolice.apadters.department
import com.mhl.madpolice.databinding.FragmentDepartmentBinding
import com.mhl.madpolice.menuActivity.SignedActivity
import com.mhl.madpolice.recycleradapters.DepartmentRecyclerAdapter
import com.mhl.madpolice.retrofit.MyRetrofit
import com.mhl.madpolice.retrofit.retrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DepartmentFragment : Fragment() {

    private lateinit var viewBinding : FragmentDepartmentBinding
    private lateinit var department: ArrayList<department>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDepartmentBinding.inflate(inflater)

        var retrofit = MyRetrofit().retrofit()
        var api = retrofit.create(retrofitApi::class.java)
        api.getDepartment().enqueue(object : Callback<department>{
            override fun onResponse(call: Call<department>, response: Response<department>) {
                if (response.isSuccessful){

                    viewBinding.departmentsRecycler.adapter = response.body().let { DepartmentRecyclerAdapter(
                        it!!.data, requireContext()) }
                }
            }

            override fun onFailure(call: Call<department>, t: Throwable) {
            }

        })
        viewBinding.backButtonMain.setOnClickListener {
            if (!activity?.getPreferences(Context.MODE_PRIVATE)?.getString(getString(R.string.id), "").equals(""))
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container_signed, MenuFragment())
                    ?.commit()
            else
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container_view, GuestMenuFragment())
                    ?.commit()
        }



        return viewBinding.root
    }
}