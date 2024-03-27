package com.example.redi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.session2_forgot_password)

        val signIn: TextView = findViewById(R.id.SignIn)
        val emailAddressInput = findViewById<EditText>(R.id.EmailAddress_input)
        val SendOtp = findViewById<ImageButton>(R.id.SendOTP)
        SendOtp.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val emailAddress = emailAddressInput.text.toString()


                if (emailAddress.isNotEmpty()) {
                    SendOtp.setImageResource(R.drawable.sendotp)
                    SendOtp.isEnabled = true

                } else {
                    SendOtp.setImageResource(R.drawable.sendotpbefore)

                }

            }
        }

        emailAddressInput.addTextChangedListener(textWatcher)

        signIn.setOnClickListener{
            val intent2 = Intent(this, WelcomeBack::class.java)
            startActivity(intent2)
        }
        SendOtp.setOnClickListener {
            if (SendOtp.isEnabled){
                val intent = Intent(this@ForgotPassword, OTPverification::class.java)
                startActivity(intent)
            }
        }
    }
}