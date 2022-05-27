package com.nepplus.android_retrofit.ui.setting

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.nepplus.android_retrofit.BaseActivity
import com.nepplus.android_retrofit.R
import com.nepplus.android_retrofit.databinding.ActivityDetailProfileBinding
import com.nepplus.android_retrofit.ui.main.LoginActivity
import com.nepplus.android_retrofit.utils.ContextUtil
import com.nepplus.android_retrofit.utils.GlobalData

class DetailProfileActivity : BaseActivity() {

    var loginUser = GlobalData.loginUser!!

    lateinit var binding : ActivityDetailProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_profile)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.logoutBtn.setOnClickListener {
            ContextUtil.clear(mContext)

            val myIntent = Intent(mContext, LoginActivity::class.java)
            myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags((Intent.FLAG_ACTIVITY_NEW_TASK))
            startActivity(myIntent)


        }

    }

    override fun setValues() {

        Glide.with(mContext)
            .load(loginUser.profile_img)
            .into(binding.profileImg)
        binding.emailTxt.text = loginUser.email
        binding.nicknameTxt.text = loginUser.nick_name


    }
}