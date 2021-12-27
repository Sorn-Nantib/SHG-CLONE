package com.example.dashboardshg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_verify_pin_code.*

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        btn_sign_up.setOnClickListener{

           val values =  Intent(this@LogIn, VerifyPinCode::class.java)
            values.putExtra("Phone_Number",input_phone.text.toString())
            startActivity( values)
        }


    }


}