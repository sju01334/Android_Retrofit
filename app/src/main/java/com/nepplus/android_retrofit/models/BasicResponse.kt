package com.nepplus.android_retrofit.models

data class BasicResponse(
    val code : Int,
    val message : String,
    val data : DataResponse
) {
}