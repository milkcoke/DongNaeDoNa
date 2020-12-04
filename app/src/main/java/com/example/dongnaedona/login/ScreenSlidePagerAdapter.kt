package com.example.dongnaedona.login

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dongnaedona.chatting.ChattingList
import com.example.dongnaedona.donationlist.AllList
import com.example.dongnaedona.donationlist.MyList

class ScreenSlidePagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
//        Chatting + All List + My List = 3 page
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ChattingList()
            1 -> AllList()
            2 -> MyList()
            else -> AllList()
        }
    }
}
