package com.example.dongnaedona.login

import android.content.Context
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.dongnaedona.R
import com.example.dongnaedona.donationlist.DeleteCheckDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainViewPagerActivity : AppCompatActivity(),
    DeleteCheckDialogFragment.DeleteCheckListener {
//    private val iconArray = resources.obtainTypedArray(R.array.icon_array)
    private lateinit var iconArray : TypedArray
    private lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        iconArray = mContext.resources.obtainTypedArray(R.array.icon_array)
        init()
    }

    private fun init() {
        view_pager.adapter =
            ScreenSlidePagerAdapter(this)
        TabLayoutMediator(kind_of_list_tab_layout, view_pager) { tab, position ->
            tab.setIcon(iconArray.getResourceId(position, -1))
        }.attach()
    }

    override fun onDialogPositiveClick(dialog: DialogFragment, donationItemName: String) {
        Toast.makeText(mContext, "삭제되었습니다", Toast.LENGTH_SHORT).show()
        dialog.dismiss()
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        dialog.dismiss()
    }
}