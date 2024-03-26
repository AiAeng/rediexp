package com.example.redi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton

class NewPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.session2_new_password)

        val passwordInput = findViewById<EditText>(R.id.Password_input)
        val passwordConfInput = findViewById<EditText>(R.id.PasswordConf_input)
        val login: ImageButton = findViewById(R.id.login)
        login.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val password = passwordInput.text.toString()
                val passwordConf = passwordConfInput.text.toString()

                if (password.isNotEmpty() && passwordConf.isNotEmpty() && password == passwordConf) {
                    login.setImageResource(R.drawable.log_in)
                    login.isEnabled = true
                } else {
                    login.setImageResource(R.drawable.log_in_before)

                }
            }
        }

        passwordInput.addTextChangedListener(textWatcher)
        passwordConfInput.addTextChangedListener(textWatcher)

        login.setOnClickListener {
            if (login.isEnabled) {
                val intent = Intent(this@NewPassword, Home::class.java)
                startActivity(intent)
            }
        }
    }
}