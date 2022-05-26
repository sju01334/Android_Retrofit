package com.nepplus.android_retrofit.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nepplus.android_retrofit.fragments.*

class MainViewPagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount() =5

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> FeedFragment()
            1 -> StatFragment()
            2 -> HomeFragment()
            3 -> TimeTableFragment()
            else -> SettingFragment()

        }

    }
}