package com.nepplus.android_retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.nepplus.android_retrofit.models.BasicResponse
import com.nepplus.android_retrofit.models.UserData
import com.nepplus.android_retrofit.utils.ContextUtil
import com.nepplus.android_retrofit.utils.GlobalData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : BaseActivity() {

    var isTokenOk = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        val token = ContextUtil.getLoginToken(mContext)
//        토큰의 유효성 검사
//        1) 서버에 토근으로 로그인할 수 있는 API 가 있느가?
//        2) 파라미터로 토큰만 받아서 접속 할 수 있는가
//        3) 로그인시 내려주는 response 와 비슷한 response 를 내려주는가
        apiList.getRequestMainInfo(token).enqueue(object : Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if(response.isSuccessful){
                    isTokenOk= true
                    val user = response.body()!!.data.user

                    GlobalData.loginUser = user
                }else {
                    Log.d("응답실패다", "실패다")
                }
            }
            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
            }
        })


    }

    override fun setValues() {
        var myHandler = Handler(Looper.getMainLooper())


        myHandler.postDelayed({
            val isAutoLoginOk = ContextUtil.getAutoLogin(mContext)

            val myIntent : Intent

            if(isAutoLoginOk && isTokenOk){
                myIntent = Intent(mContext, MainActivity::class.java)
            }else {
                myIntent = Intent(mContext, LoginActivity::class.java)
            }
            startActivity(myIntent)
            finish()

        }, 1500)

    }
}