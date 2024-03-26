package com.example.redi

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.session1_splash_screen)

        // Это используется, чтобы скрыть строку состояния и сделать
        // заставку полноэкранной.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // используется метод postDelayed(Runnable, time)
        // для отправки сообщения с задержкой по времени.
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SplashScreen1::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}