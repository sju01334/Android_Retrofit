package com.nepplus.android_retrofit

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.nepplus.android_retrofit.adapters.MainViewPagerAdapter
import com.nepplus.android_retrofit.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var mPagerAdapter : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        mPagerAdapter = MainViewPagerAdapter(this)
        binding.mainViewPager.adapter = mPagerAdapter

        binding.mainViewPager.offscreenPageLimit = 5
        binding.mainViewPager.currentItem = 2
        binding.bottomNav.selectedItemId = R.id.home

        binding.mainViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNav.menu.getItem(position).isChecked = true
            }
        })

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.layout.fragment_feed -> binding.mainViewPager.currentItem = 0
                R.layout.fragment_stat -> binding.mainViewPager.currentItem = 1
                R.layout.fragment_home -> binding.mainViewPager.currentItem = 2
                R.layout.fragment_time_table -> binding.mainViewPager.currentItem = 3
                R.layout.fragment_setting -> binding.mainViewPager.currentItem = 4
            }
            return@setOnItemSelectedListener true
        }

    }
}