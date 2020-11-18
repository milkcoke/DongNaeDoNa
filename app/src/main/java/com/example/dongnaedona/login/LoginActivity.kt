package com.example.dongnaedona.login

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.dongnaedona.R
import kotlinx.android.synthetic.main.activity_login.*
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        addTextChangeListener()
        addLoginButtonClickListener()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
    private fun addLoginButtonClickListener(){
        login_button.setOnClickListener {
            login_button.startAnimation()
            val mHandler = Handler()
            mHandler.postDelayed(Runnable {
                login_button.doneLoadingAnimation(resources.getColor(R.color.white), BitmapFactory.decodeResource(resources,
                    R.drawable.checked
                ))
                mHandler.postDelayed({
                    val intent = Intent(this, MainViewPagerActivity::class.java)
                    startActivity(intent)
                },500)

            }, 3000)
        }
    }
    private fun addTextChangeListener() {
        edit_text_apartmentNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                apartmentNumber_input_layout.hint = null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        edit_text_password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                password_input_layout.hint = null
                if (s.toString().length >= 3) login_button.isEnabled = true
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }
}


