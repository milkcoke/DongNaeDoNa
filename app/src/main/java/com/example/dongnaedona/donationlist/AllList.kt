package com.example.dongnaedona.donationlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dongnaedona.R
import com.example.dongnaedona.model.DonationInfo

class AllList : androidx.fragment.app.Fragment() {

    private lateinit var donationListRecyclerView: RecyclerView
    private lateinit var allDonationListAdapter : AllDonationListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_all_list, container, false)
//
        donationListRecyclerView = rootView.findViewById(R.id.all_donation_list_recyclerView)
//        donationListRecyclerView.setHasFixedSize(true)
        donationListRecyclerView.layoutManager = LinearLayoutManager(rootView.context, LinearLayoutManager.VERTICAL, false)
//        DonationInfo("참치 통조림", 1003, 106, "방문해주세요")
        val tempDonationDataList = Array<DonationInfo>(10){DonationInfo(R.drawable.canned_tuna, "참치 통조림", 1003, 106, "방문해주세요")}.toList() as ArrayList<DonationInfo>
        tempDonationDataList.add(0, DonationInfo(R.drawable.shoes, "거의 새신발", 1004, 1702, "경비실에 두고가요"))
        tempDonationDataList.add(1, DonationInfo(R.drawable.scarf, "노란 스카프", 1004, 1601, "채팅 문의해주세요"))
        allDonationListAdapter = AllDonationListAdapter(tempDonationDataList)

        donationListRecyclerView.adapter = allDonationListAdapter
        // Inflate the layout for this fragment
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
    }

}
