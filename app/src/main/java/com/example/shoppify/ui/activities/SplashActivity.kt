package com.example.shoppify.ui.activities

import android.content.Intent
import android.graphics.Typeface.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.shoppify.R
import com.example.shoppify.firestore.FirestoreClass
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler().postDelayed(
            {

                val currentUserID = FirestoreClass().getCurrentUserID()

                if (currentUserID.isNotEmpty()) {
                    // Launch dashboard screen.
                    startActivity(Intent(this@SplashActivity, DashBoardActivity::class.java))
                } else {
                    // Launch the Login Activity
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                }
                finish()
            },
            2500
        )

    }
}