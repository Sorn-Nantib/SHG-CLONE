package com.example.dashboardshg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_verify_pin_code.*
import kotlinx.android.synthetic.main.activity_verify_pin_code.view.*

class VerifyPinCode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val i = Intent(this, MainActivity::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_pin_code)
        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val value = intent.getStringExtra("Phone_Number")
        phone.setText("(+855 $value)")

        inputCode1.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // TODO Auto-generated method stub
                if (inputCode1.text.length == 1) //size as per your requirement
                {
                    inputCode2.requestFocus()
                }
            }

            override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                // TODO Auto-generated method stub
            }
        })
        inputCode2.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // TODO Auto-generated method stub
                if (inputCode2.text.length == 1) //size as per your requirement
                {
                    inputCode3.requestFocus()
                }
            }

            override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {

                // TODO Auto-generated method stub
            }
        })

        inputCode3.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // TODO Auto-generated method stub
                if (inputCode3.text.length == 1) //size as per your requirement
                {
                    inputCode4.requestFocus()
                }
            }

            override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        inputCode4.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // TODO Auto-generated method stub

            }

            override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                if (inputCode1.text.toString() == "1" && inputCode2.text.toString() == "2" && inputCode3.text.toString() == "3" && inputCode4.text.toString() == "4") {
                    startActivity(i)
                    finish()
                } else {

                    val snackbar = Snackbar.make(verify_layout, "Simple Snackbar ", Snackbar.LENGTH_LONG)

                    snackbar.show()
                }
            }
        })

        setupActionBar()

        btn_again.setOnClickListener{
            startActivity(Intent(this@VerifyPinCode, MainActivity::class.java))
        }


    }


    private fun setupActionBar() {

        setSupportActionBar(app_bar_verify)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_iconback)
        }

        app_bar_verify.setNavigationOnClickListener { onBackPressed() }
    }


}


