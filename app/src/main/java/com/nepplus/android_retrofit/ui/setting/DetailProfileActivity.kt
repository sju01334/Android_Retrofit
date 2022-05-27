package com.nepplus.android_retrofit.ui.setting

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nepplus.android_retrofit.BaseActivity
import com.nepplus.android_retrofit.R
import com.nepplus.android_retrofit.databinding.ActivityDetailProfileBinding

class DetailProfileActivity : BaseActivity() {

    lateinit var binding : ActivityDetailProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_profile)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {


    }

    override fun setValues() {

    }
}