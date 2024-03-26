package com.example.redi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class SplashScreen3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.session1_splash_screen3)

        val signup: ImageButton = findViewById(R.id.signUp)
        val signin: TextView = findViewById(R.id.SignIn)

        signup.setOnClickListener{
            val intent1 = Intent(this, CreateAnAccount::class.java)
            startActivity(intent1)
        }
        signin.setOnClickListener{
            val intent2 = Intent(this, WelcomeBack::class.java)
            startActivity(intent2)
        }
    }
}