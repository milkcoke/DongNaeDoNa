package com.example.dongnaedona.donationlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dongnaedona.R
import com.example.dongnaedona.model.DonationInfo

class DonationListAdapter(
    private var donationListArray: ArrayList<DonationInfo>
): RecyclerView.Adapter<DonationListAdapter.MyViewHolder>(){
// 특정값 필터링 원하면 Filterable 사용
//    ex) '나'의 기부 리스트 => Filterable
    interface onItemClickListener {
        fun onItemClick(holder: MyViewHolder, view: View, data: String, position: Int)
    }
    var itemClickListener: onItemClickListener? = null
    private var itemsFilterList = ArrayList<DonationInfo>()

    init {
        itemsFilterList = donationListArray
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.donation_list_row, parent, false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemsFilterList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var goodsNameTextView = itemView.findViewById(R.id.goods_name) as TextView
        var buildingNumberAndUnitTextView = itemView.findViewById(R.id.building_and_unit_number) as TextView
        var wayOfDonationTextView = itemView.findViewById(R.id.way_of_donation) as TextView
    }

    // 뷰홀더에 해당하는 것이 전달됨.(내용만 교체할때 호출됨)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.goodsNameTextView.text = itemsFilterList[position].name
        val stringBuilder = StringBuilder()
        stringBuilder.append(itemsFilterList[position].buildingNumber.toString())
            .append("동 ")
            .append(itemsFilterList[position].unitNumber.toString())
            .append("호")
        holder.buildingNumberAndUnitTextView.text = stringBuilder.toString()
        holder.wayOfDonationTextView.text = itemsFilterList[position].wayOfDonation
    }

}
