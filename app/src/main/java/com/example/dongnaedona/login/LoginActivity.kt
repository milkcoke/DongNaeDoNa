package com.example.dongnaedona.login

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dongnaedona.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
//    private val mContext = this@LoginActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        addTextChangeListener()
        initializeSpinner()
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

            }, 2000)
        }
    }
    private fun initializeSpinner(){
        basement_level_spinner.apply{
            getSpinnerRecyclerView().layoutManager = GridLayoutManager(this@LoginActivity, 3)
            //        기본 값으로 1층을 줌.
            selectItemByIndex(0)
        }
//        바깥 클릭되면 자동으로 닫힘
        basement_level_spinner.setOnSpinnerOutsideTouchListener{_, _->
            basement_level_spinner.dismiss()
        }
        ho_spinner.setOnSpinnerOutsideTouchListener { _, _ ->
            ho_spinner.dismiss()
        }
    }
    private fun addTextChangeListener() {

        edit_text_password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                password_input_layout.hint = null
                if (s.toString().length >= 6) login_button.isEnabled = true
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }
}


