package com.example.redi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class SplashScreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.session1_splash_screen2)

        val skip: ImageButton = findViewById(R.id.skip_splashscreen2)
        val next: ImageButton = findViewById(R.id.next_splashscreen2)

        skip.setOnClickListener{
            val intent1 = Intent(this, SplashScreen3::class.java)
            startActivity(intent1)
        }
        next.setOnClickListener{
            val intent2 = Intent(this, SplashScreen3::class.java)
            startActivity(intent2)
        }
    }
}