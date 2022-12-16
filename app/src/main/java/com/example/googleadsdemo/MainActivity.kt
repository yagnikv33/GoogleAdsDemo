package com.example.googleadsdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ads = findViewById<AdView>(R.id.adView)

        MobileAds.initialize(this@MainActivity)

        val adRequest = AdRequest.Builder().build()
        ads.loadAd(adRequest)


        nextBannerAdd()
    }

    private fun nextBannerAdd() {
        findViewById<Button>(R.id.btn_next_screen).setOnClickListener {
            val i = Intent(this, AdModAct::class.java)
            startActivity(i)
        }
    }
}