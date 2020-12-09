package com.example.dongnaedona.donation

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.dongnaedona.R
import com.example.dongnaedona.login.MainViewPagerActivity
import kotlinx.android.synthetic.main.activity_register_goods.*
import java.io.InputStream


class RegisterGoods : AppCompatActivity() {
    private lateinit var multipleTextWatcher : TextWatcher
//    private lateinit var launcherInstance : ActivityResultLauncher<Uri?>
    private lateinit var launcherInstance : ActivityResultLauncher<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_goods)
        imageSelectButtonInitialize()
        inputInitialize()
        addButtonTextWatcher()
        addAllTextWatcher()
        addRegisterDonationButtonClickListener()
    }

    override fun onStop() {
//        입력값 초기화
        inputLayoutInitialize()
        super.onStop()
    }

    private val REQUEST_CODE = 100
    private fun imageSelectButtonInitialize() {
//        launcherInstance = registerForActivityResult(PickPhotoContract()) {
//            targetUri: Uri -> targetUri.let{
//                val inputStream : InputStream? = contentResolver.openInputStream(it)
//                val img = BitmapFactory.decodeStream(inputStream)
//                inputStream?.close()
//                add_photo_button.setImageBitmap(img)
//            }
//        }
        launcherInstance = registerForActivityResult(ActivityResultContracts.GetContent()) {
            targetUri : Uri ->
                val inputStream : InputStream? = contentResolver.openInputStream(targetUri)
                val img = BitmapFactory.decodeStream(inputStream)
                inputStream?.close()
                add_photo_button.setImageBitmap(img)
        }
        add_photo_button.setOnClickListener {
//            val pickPhotoIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            launcherInstance.launch("image/*")
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if(resultCode != RESULT_CANCELED) {
//            when (requestCode) {
//                REQUEST_CODE -> {
//                    if (resultCode === RESULT_OK && data !== null) {
//                        val inputStream: InputStream? = contentResolver.openInputStream(data.data!!)
//                        val img = BitmapFactory.decodeStream(inputStream)
//                        inputStream?.close()
//                        add_photo_button.setImageBitmap(img)
//                    }
//                }
//                else-> {
//                    return
//                }
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data)
//    }

    private fun inputInitialize(){
        val methodArray = resources.getStringArray(R.array.donation_method)

        val adapter = ArrayAdapter<String>(this@RegisterGoods, R.layout.dropdown_donation_method_popup_item, methodArray)
        donation_method_autoCompleteTextView.setAdapter(adapter)

        goods_description_layout.setOnClickListener {
            goods_description_layout.gravity = Gravity.START
            goods_description_editText.gravity = Gravity.START
        }
        goods_description_editText.setOnClickListener {
            goods_description_layout.gravity = Gravity.START
            goods_description_editText.gravity = Gravity.START
        }
    }

    private fun addRegisterDonationButtonClickListener(){
        register_donation_button.setOnClickListener {
            register_donation_button.startAnimation()
            val mHandler = Handler()
            mHandler.postDelayed(Runnable {
                register_donation_button.doneLoadingAnimation(getColor(R.color.white), BitmapFactory.decodeResource(resources, R.drawable.checked))
                mHandler.postDelayed({
                    val intent = Intent(this, MainViewPagerActivity::class.java)
                    intent.putExtra("MY_DONATION_TAB", 2)
                    startActivity(intent)
                }, 500)

            }, 2000)
        }
    }

    private fun inputLayoutInitialize() {
        goods_name_editText.text?.clear()
        goods_name_inputLayout.error = null
        goods_name_inputLayout.clearFocus()

        goods_description_editText.text?.clear()
        goods_description_layout.clearFocus()
        goods_description_layout.error = null

        donation_method_layout.clearFocus()
        donation_method_layout.error = null
        donation_method_autoCompleteTextView.text.clear()
    }

    private fun addButtonTextWatcher() {
        multipleTextWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                for(editText: EditText in arrayOf(goods_name_editText, goods_description_editText, donation_method_autoCompleteTextView)) {
                    try {
                        Log.i("Special", "${editText.text}")
                        if(editText.text === null) {
                            Log.i("Special", "this is null!!!!!")
                            throw NullPointerException()
                        }
                    } catch (e : NullPointerException) {
                        e.printStackTrace()
                        register_donation_button.isEnabled = false
                        return
                    }
                }
                register_donation_button.isEnabled = true
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }
    }

    private fun addAllTextWatcher() {
        goods_name_editText.addTextChangedListener(multipleTextWatcher)
        goods_description_editText.addTextChangedListener(multipleTextWatcher)
        donation_method_autoCompleteTextView.addTextChangedListener(multipleTextWatcher)
    }

}