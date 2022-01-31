package com.mhl.madpolice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.mhl.madpolice.apadters.Login
import com.mhl.madpolice.databinding.ActivitySignInBinding
import com.mhl.madpolice.menuActivity.GuestActivity
import com.mhl.madpolice.retrofit.MyRetrofit
import com.mhl.madpolice.retrofit.retrofitApi
import retrofit2.*

class SignInActivity : AppCompatActivity() {


    private lateinit var viewBinding : ActivitySignInBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        var login = viewBinding.editLogin.text.toString()
        var password = viewBinding.editPassword.text.toString()
        viewBinding.signInButton.setOnClickListener {
            val myRetrofit = MyRetrofit().retrofit()
            val retrofitApi = myRetrofit.create(retrofitApi::class.java)
            val query = retrofitApi.getLogin(login, password)
            query.enqueue(object : Callback<Login>{
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.isSuccessful){
                        val intent = Intent(this@SignInActivity, GuestActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Log.d("FUCK UP", t.toString())
                }

            })
        }
        viewBinding.guestButton.setOnClickListener {

        }
    }
}