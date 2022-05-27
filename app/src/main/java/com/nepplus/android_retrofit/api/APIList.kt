package com.nepplus.android_retrofit.api

import com.nepplus.android_retrofit.models.BasicResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface APIList {

//    user

    @FormUrlEncoded
    @PATCH("/user")
    fun patchReqeustEditUser(
        @Header("X-Http-Token") token : String,
        @Field("nick_name") nickname : String?,
        @Field("current_password") currentPw : String?,
        @Field("new_password") newPw : String?
    ) : Call<BasicResponse>

            @FormUrlEncoded //파라미터중에 폼데이터로 담아야 하는 파라미터 있다면 작성
    @POST("/user")
    fun postRequestLogin(
        @Field("email") email: String,
        @Field("password") pw: String) : Call<BasicResponse>

    @FormUrlEncoded
    @PUT("/user")
    fun putRequestSignup (
        @Field("email") email: String,
        @Field("password") pw: String,
        @Field("nick_name") nick : String
    ) : Call<BasicResponse>

//    main
    @GET("/main_info")
    fun getRequestMainInfo(@Header("X-Http-Token") token : String) : Call<BasicResponse>




}