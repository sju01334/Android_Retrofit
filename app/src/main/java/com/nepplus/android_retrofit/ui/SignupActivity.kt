package com.nepplus.android_retrofit.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.nepplus.android_retrofit.BaseActivity
import com.nepplus.android_retrofit.R
import com.nepplus.android_retrofit.databinding.ActivitySignupBinding
import com.nepplus.android_retrofit.models.BasicResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : BaseActivity() {

    lateinit var  binding : ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {


        binding.signUpBtn.setOnClickListener {
            val inputEmail = binding.emailEdt.text.toString()
            val inputPw = binding.passwordEdt.text.toString()
            val inputNick = binding.nicknameEdt.text.toString()

                apiList.putRequestSignup(
                    inputEmail,
                    inputPw,
                    inputNick).enqueue(object : Callback<BasicResponse>{
                    override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                        if(response.isSuccessful) {
                            val br = response.body()!!
                            Toast.makeText(
                                mContext,
                                "${br.data.user.nick_name} 님 가입을 환영합니다",
                                Toast.LENGTH_SHORT
                            ).show()
                        }else {
                            val errorBody = response.errorBody()!!

                            val jsonObj = JSONObject(errorBody.toString())
                            val message = jsonObj.getString("message")
                            Log.d("에러 응답", message)
                        }
                    }

                    override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })
        }


    }

    override fun setValues() {

    }
}