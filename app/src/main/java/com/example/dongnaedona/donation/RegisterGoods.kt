package com.example.dongnaedona.donation

import android.os.Bundle
import android.view.Gravity
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.dongnaedona.R
import kotlinx.android.synthetic.main.activity_register_goods.*

class RegisterGoods : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_goods)
        inputInitialize()
    }

    private fun inputInitialize(){
        val methodArray = resources.getStringArray(R.array.donation_method)

        val adapter = ArrayAdapter<String>(this@RegisterGoods, R.layout.dropdown_donation_method_popup_item, methodArray)
        donation_method_autoCompleteTextView.setAdapter(adapter)

        goods_description_layout.setOnClickListener {
            goods_description_editText.gravity = Gravity.START
        }
        goods_description_editText.setOnClickListener {
            goods_description_editText.gravity = Gravity.START
        }

    }
}