package com.nepplus.android_retrofit.models

data class DataResponse(
    val user : UserData,
    val token : String,
    val total_goal_seconds : Int
) {
}