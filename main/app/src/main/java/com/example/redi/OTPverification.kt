package com.example.redi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class OTPverification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.session2_otpverification)

        val num1: EditText = findViewById(R.id.inputNumber1)
        val num2: EditText = findViewById(R.id.inputNumber2)
        val num3: EditText = findViewById(R.id.inputNumber3)
        val num4: EditText = findViewById(R.id.inputNumber4)
        val num5: EditText = findViewById(R.id.inputNumber5)
        val num6: EditText = findViewById(R.id.inputNumber6)
        val resend: TextView = findViewById(R.id.resend)
        val SetNewPass: ImageButton = findViewById(R.id.SetNewPass)

        SetNewPass.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val number1 = num1.text.toString()
                val number2 = num2.text.toString()
                val number3 = num3.text.toString()
                val number4 = num4.text.toString()
                val number5 = num5.text.toString()
                val number6 = num6.text.toString()

                if (number1.isNotEmpty() &&
                    number2.isNotEmpty() &&
                    number3.isNotEmpty() &&
                    number4.isNotEmpty() &&
                    number5.isNotEmpty() &&
                    number6.isNotEmpty()
                ) {
                    SetNewPass.setImageResource(R.drawable.set_new_password)
                    SetNewPass.isEnabled = true
                    }
                else {
                    SetNewPass.setImageResource(R.drawable.set_new_password_gray)


                }
            }
        }

                num1.addTextChangedListener(textWatcher)
                num2.addTextChangedListener(textWatcher)
                num3.addTextChangedListener(textWatcher)
                num4.addTextChangedListener(textWatcher)
                num5.addTextChangedListener(textWatcher)
                num6.addTextChangedListener(textWatcher)

        SetNewPass.setOnClickListener {
            if (SetNewPass.isEnabled){
                val intent = Intent(this, NewPassword::class.java)
                startActivity(intent)
            }
        }


            }
        }

