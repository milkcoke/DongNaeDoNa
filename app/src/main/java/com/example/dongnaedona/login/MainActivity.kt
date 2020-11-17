package com.example.dongnaedona.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dongnaedona.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainViewPagerActivity : AppCompatActivity() {
    private val tabNameArray = arrayOf("기부 리스트", "내 기부")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        view_pager.adapter =
            ScreenSlidePagerAdapter(this)
        TabLayoutMediator(kind_of_list_tab_layout, view_pager) { tab, position ->
            tab.text = tabNameArray[position]
        }.attach()
        //attach() :    Link the TabLayout and the ViewPager2 together.
        // Must be called after ViewPager2 has an adapter set

    }
}