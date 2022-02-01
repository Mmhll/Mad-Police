package com.mhl.madpolice

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mhl.madpolice.apadters.Login
import com.mhl.madpolice.apadters.LoginData
import com.mhl.madpolice.databinding.ActivitySignInBinding
import com.mhl.madpolice.menuActivity.GuestActivity
import com.mhl.madpolice.menuActivity.SignedActivity
import com.mhl.madpolice.retrofit.MyRetrofit
import com.mhl.madpolice.retrofit.retrofitApi
import retrofit2.*

class SignInActivity : AppCompatActivity() {


    private lateinit var viewBinding : ActivitySignInBinding

    private lateinit var data: LoginData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.signInButton.setOnClickListener {

            var login = viewBinding.editLogin.text.toString()
            var password = viewBinding.editPassword.text.toString()
            Log.d("LOGIN", login)
            Log.d("PASSWORD", password)
            val myRetrofit = MyRetrofit().retrofit()
            val retrofitApi = myRetrofit.create(retrofitApi::class.java)
            val query = retrofitApi.getLogin(login, password)
            query.enqueue(object : Callback<Login>{
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.isSuccessful) {

                        val prefs = getSharedPreferences("USER", MODE_PRIVATE)
                        response.body()?.let {
                            prefs.edit()
                                .putString(getString(R.string.id), it.data.id)
                                .putString(getString(R.string.token), it.data.token)
                                .apply().let {
                                    Log.d("SUCCESS", "NU TI PONYAL")
                                }
                        }
                        startActivity(Intent(this@SignInActivity, SignedActivity::class.java))
                        finish()

                    }
                    else{
                            Log.d("RESPONSE", response.message())
                        }
                    }


                override fun onFailure(call: Call<Login>, t: Throwable) {

                }

            })
        }
        viewBinding.guestButton.setOnClickListener {
            val intent = Intent(this@SignInActivity, GuestActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}