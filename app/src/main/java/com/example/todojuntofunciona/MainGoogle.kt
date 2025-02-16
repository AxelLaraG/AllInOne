package com.example.todojuntofunciona

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainGoogle : AppCompatActivity() {

    lateinit var mAdView1: AdView
    lateinit var mAdView2: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_google)
        loadBannerAd()

        val btnReturn = findViewById<Button>(R.id.btnReturnGoogle)

        btnReturn.setOnClickListener(View.OnClickListener {
            val intent = Intent(
                this@MainGoogle,
                MainMenu::class.java
            )
            startActivity(intent)
            finish() // Cierra esta Activity
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainGoogle)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadBannerAd(){
        MobileAds.initialize(this)

        mAdView1 = findViewById(R.id.adView1)
        mAdView2 = findViewById(R.id.adView2)
        val adRequest = com.google.android.gms.ads.AdRequest.Builder().build()
        mAdView1.loadAd(adRequest)
        mAdView2.loadAd(adRequest)

    }



}