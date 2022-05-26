package com.nepplus.android_retrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nepplus.android_retrofit.api.APIList
import com.nepplus.android_retrofit.api.ServerAPI
import com.nepplus.android_retrofit.databinding.ActivityLoginBinding
import com.nepplus.android_retrofit.models.BasicResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

        binding.signUpBtn.setOnClickListener {
            val myIntent = Intent(mContext, SignupActivity::class.java)
            startActivity(myIntent)
        }

//        val inputEmail = "kmc@test.com"
//        val inputPw = "Test!1231"

        binding.loginBtn.setOnClickListener {

            val inputEmail = binding.emailEdt.text.toString()
            val inputPw = binding.passwordEdt.text.toString()

            apiList.postRequestLogin(inputEmail, inputPw).enqueue(object : Callback<BasicResponse> {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {


                    if (response.isSuccessful) {
                        Log.d("서버 성공 응답", response.body().toString())
                    } else {
                        val errorBody = response.errorBody()!!
                        Log.d("에러 응답", errorBody.toString())

                        val jsonObj = JSONObject(errorBody.string())
                        val message = jsonObj.getString("message")
                        val code = jsonObj.getInt("code")
                        Log.d("에러 응답", message)
                        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }
            })
        }
    }

    override fun setValues() {

    }
}