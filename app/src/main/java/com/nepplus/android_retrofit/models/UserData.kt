package com.nepplus.android_retrofit.models

data class UserData(
    val id : Int,
    val email : String,
    val nick_name : String,
    val profile_img : String,
    val groups : List<GroupData>
) {
}