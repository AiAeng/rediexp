package com.example.redi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class SplashScreen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.session1_splash_screen1)

        val skip: ImageButton = findViewById(R.id.skip_splashscreen1)
        val next: ImageButton = findViewById(R.id.next_splashscreen1)

        skip.setOnClickListener{
            val intent1 = Intent(this, SplashScreen3::class.java)
            startActivity(intent1)
        }
        next.setOnClickListener{
            val intent2 = Intent(this, SplashScreen2::class.java)
            startActivity(intent2)
        }

    }
}