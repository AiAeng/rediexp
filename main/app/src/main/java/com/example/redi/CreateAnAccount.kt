package com.example.redi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreateAnAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.session2_create_an_account)

        val fullNameInput = findViewById<EditText>(R.id.FullName_input)
        val phoneNumberInput = findViewById<EditText>(R.id.PhoneNumber_input)
        val emailAddressInput = findViewById<EditText>(R.id.EmailAddress_input)
        val passwordInput = findViewById<EditText>(R.id.Password_input)
        val passwordConfInput = findViewById<EditText>(R.id.PasswordConf_input)
        val signUpButton = findViewById<ImageButton>(R.id.signUp)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val signIn: TextView = findViewById(R.id.SignIn)
        signUpButton.isEnabled = false

        val fullText = checkBox.text.toString()
        val spannableString = SpannableString(fullText)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
                )
                startActivity(intent)
            }
        }

        val startIndex = fullText.indexOf("Terms and сonditions and private policy")
        val endIndex = startIndex + "Terms and сonditions and private policy".length

        spannableString.setSpan(
            clickableSpan,
            startIndex,
            endIndex,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            android.text.style.ForegroundColorSpan(
                android.graphics.Color.parseColor(
                    "#EBBC2E"
                )
            ), startIndex, endIndex, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        checkBox.text = spannableString
        checkBox.movementMethod = LinkMovementMethod.getInstance()


        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val fullName = fullNameInput.text.toString()
                val phoneNumber = phoneNumberInput.text.toString()
                val emailAddress = emailAddressInput.text.toString()
                val password = passwordInput.text.toString()
                val passwordConf = passwordConfInput.text.toString()

                val isChecked = checkBox.isChecked


                if (fullName.isNotEmpty() &&
                    phoneNumber.isNotEmpty() &&
                    emailAddress.isNotEmpty() &&
                    password.isNotEmpty() &&
                    passwordConf.isNotEmpty() &&
                    password == passwordConf &&
                    isChecked
                ) {
                    signUpButton.setImageResource(R.drawable.signup)
                    signUpButton.isEnabled = true
                } else {
                    signUpButton.setImageResource(R.drawable.signup_before)

                }
            }
        }

        fullNameInput.addTextChangedListener(textWatcher)
        phoneNumberInput.addTextChangedListener(textWatcher)
        emailAddressInput.addTextChangedListener(textWatcher)
        passwordInput.addTextChangedListener(textWatcher)
        passwordConfInput.addTextChangedListener(textWatcher)
        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            textWatcher.afterTextChanged(null) // Повторная проверка при изменении состояния CheckBox
        }

        signIn.setOnClickListener {
            val intent2 = Intent(this, WelcomeBack::class.java)
            startActivity(intent2)
        }

        signUpButton.setOnClickListener {
            if (signUpButton.isEnabled) {
                val intent = Intent(this@CreateAnAccount, Home::class.java)
                startActivity(intent)
            }
        }
    }
}
