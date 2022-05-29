package com.nepplus.android_retrofit.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nepplus.android_retrofit.R
import com.nepplus.android_retrofit.databinding.FragmentHomeBinding
import com.nepplus.android_retrofit.ui.goal.AddGoalActivity
import java.util.*

class HomeFragment : BaseFragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.addGoalBtn.setOnClickListener {
            val myIntent = Intent(mContext, AddGoalActivity::class.java)
            startActivity(myIntent)
        }

        binding.faBtn.setOnClickListener {
            val myIntent = Intent(mContext, AddGoalActivity::class.java)
            startActivity(myIntent)
        }

    }

    override fun setValues() {
        val myCal = Calendar.getInstance()
        val month = myCal.get(Calendar.MONTH)
        val day = myCal.get(Calendar.DATE)

        binding.titleTxt.text = "${month+1}월 ${day}일"
    }
}