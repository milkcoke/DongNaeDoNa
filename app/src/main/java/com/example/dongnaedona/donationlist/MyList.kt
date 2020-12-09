package com.example.dongnaedona.donationlist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dongnaedona.R
import com.example.dongnaedona.donation.RegisterGoods
import com.example.dongnaedona.model.DonationInfo
import kotlinx.android.synthetic.main.fragment_my_list.*

class MyList : androidx.fragment.app.Fragment() {
    private lateinit var donationListRecyclerView: RecyclerView
    private lateinit var myDonationListAdapter : MyDonationListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_my_list, container, false)
//
        donationListRecyclerView = rootView.findViewById(R.id.my_donation_list_recyclerView)
//        donationListRecyclerView.setHasFixedSize(true)
        donationListRecyclerView.layoutManager = LinearLayoutManager(rootView.context, LinearLayoutManager.VERTICAL, false)
//        DonationInfo("참치 통조림", 1003, 106, "방문해주세요")
        val tempDonationDataList = ArrayList<DonationInfo>()
        tempDonationDataList.add(0, DonationInfo(R.drawable.shoes, "거의 새신발", 1003, 1702, "경비실에 두고가요"))
        tempDonationDataList.add(1, DonationInfo(R.drawable.scarf, "노란 스카프", 1003, 1601, "채팅 문의해주세요"))
        myDonationListAdapter = MyDonationListAdapter(tempDonationDataList)

        donationListRecyclerView.adapter = myDonationListAdapter
        // Inflate the layout for this fragment
        return rootView
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {

        register_donation_button.setOnClickListener {
            val addPhotoIntent = Intent(context, RegisterGoods::class.java)
            startActivity(addPhotoIntent)
        }
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(rootView: View, savedInstanceState: Bundle?) {
//        donationListRecyclerView.(R.layout.donation_list_row).visibility = View.GONE
        super.onViewCreated(rootView, savedInstanceState)
    }

    private fun showDeleteCheckDialog(goodsName:String) {
        val deleteCheckFragment = DeleteCheckDialogFragment()
        val argumentBundle = Bundle()
        argumentBundle.putString("GOODS_NAME", goodsName)
        deleteCheckFragment.arguments = argumentBundle
        deleteCheckFragment.show(requireActivity().supportFragmentManager, "GOODS_DELETE_CHECK")
    }

}