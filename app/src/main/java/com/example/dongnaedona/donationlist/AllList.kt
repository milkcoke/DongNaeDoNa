package com.example.dongnaedona.donationlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dongnaedona.R

class AllList : androidx.fragment.app.Fragment() {

    private lateinit var donationListRecyclerView: RecyclerView
    private lateinit var donationListAdapter : DonationListAdapter
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
        donationListRecyclerView.adapter = donationListAdapter
        // Inflate the layout for this fragment
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
    }

}
