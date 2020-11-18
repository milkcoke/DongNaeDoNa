package com.example.dongnaedona.donationlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dongnaedona.R
import com.example.dongnaedona.model.DonationInfo

class MyDonationListAdapter(private var myDonationListArray : ArrayList<DonationInfo>)
    : RecyclerView.Adapter<MyDonationListAdapter.MyViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(holder: MyViewHolder, view: View, data: String, position: Int)
    }
    var itemClickListener: AllDonationListAdapter.OnItemClickListener? = null
    private var itemsFilterList = ArrayList<DonationInfo>(10)

    init {
        itemsFilterList = myDonationListArray
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_donation_list_row, parent, false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemsFilterList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var goodsImageView: ImageView = itemView.findViewById<ImageView>(R.id.goods_image)
        var goodsNameTextView: TextView = itemView.findViewById<TextView>(R.id.goods_name)
        var wayOfDonationTextView: TextView = itemView.findViewById<TextView>(R.id.way_of_donation)
        var deleteImageButton: ImageButton = itemView.findViewById<ImageButton>(R.id.delete_imageButton)
    }

    // 뷰홀더에 해당하는 것이 전달됨.(내용만 교체할때 호출됨)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.goodsImageView.setImageResource(itemsFilterList[position].imageId)
        holder.goodsNameTextView.text = itemsFilterList[position].name
        holder.wayOfDonationTextView.text = itemsFilterList[position].wayOfDonation

        holder.deleteImageButton.setOnClickListener {
            itemsFilterList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemsFilterList.size)
        }
    }

}