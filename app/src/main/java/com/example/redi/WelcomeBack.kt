package com.example.redi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class WelcomeBack : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.session2_welcome_back)

        val signUp: TextView = findViewById(R.id.SignUp)
        val emailAddressInput = findViewById<EditText>(R.id.EmailAddress_input)
        val passwordInput = findViewById<EditText>(R.id.Password_input)
        val LogInButton = findViewById<ImageButton>(R.id.logIn)
        val ForgotPass: TextView = findViewById(R.id.Forgot)

        LogInButton.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val emailAddress = emailAddressInput.text.toString()
                val password = passwordInput.text.toString()


                if (emailAddress.isNotEmpty() &&
                    password.isNotEmpty()
                ) {
                    LogInButton.setImageResource(R.drawable.log_in)
                    LogInButton.isEnabled = true

                } else {
                    LogInButton.setImageResource(R.drawable.log_in_before)

                }

            }
        }

        emailAddressInput.addTextChangedListener(textWatcher)
        passwordInput.addTextChangedListener(textWatcher)

        signUp.setOnClickListener{
            val intent2 = Intent(this, CreateAnAccount::class.java)
            startActivity(intent2)
        }

        ForgotPass.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

        LogInButton.setOnClickListener {
            if (LogInButton.isEnabled){

                val intent = Intent(this@WelcomeBack, Home::class.java)
                startActivity(intent)
            }
        }

    }
}