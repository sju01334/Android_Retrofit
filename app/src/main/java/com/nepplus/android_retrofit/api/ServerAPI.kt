package com.nepplus.android_retrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Retrofit 클래스를 객체화 함수
//생성자를 쓰지않고 굳이 객체화 하는 이유 => API 통신은 단일객체만 만들어서 화면에서 공유
//여러개 객체를 만들필요 x => singleton 패턴
class ServerAPI  {

    companion object{
//        서버 통신 담당 클래스 : 레트로핏 클래스 객체 담을 변수
        private var retrofit : Retrofit? = null
        private var BASE_URL = "http://3.37.32.230"

        fun getRetrofit() : Retrofit {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL) //어느 서버를 기반으로 움직일건지
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

    }

}