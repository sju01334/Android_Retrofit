package com.nepplus.android_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
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