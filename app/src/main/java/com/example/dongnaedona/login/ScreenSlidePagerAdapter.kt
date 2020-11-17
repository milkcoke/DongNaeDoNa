package com.example.dongnaedona.login

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dongnaedona.donationlist.AllList
import com.example.dongnaedona.donationlist.MyList

class ScreenSlidePagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
//        Nonmember + Member version = 2 page
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllList()
            1 -> MyList()
            else -> AllList()
        }
    }
}
