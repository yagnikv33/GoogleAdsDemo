package com.example.googleadsdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ads = findViewById<AdView>(R.id.adView)

        MobileAds.initialize(this@MainActivity)

        val adRequest = AdRequest.Builder().build()
        ads.loadAd(adRequest)

        ads.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.e("GoogleAds", "onAdLoaded")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                // Code to be executed when an ad request fails.
                Log.e("GoogleAds", "onAdFailedToLoad")
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.e("GoogleAds", "onAdOpened")
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.e("GoogleAds", "onAdClicked")
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.e("GoogleAds", "onAdClosed")
            }
        }

        nextBannerAdd()
    }

    private fun nextBannerAdd() {
        findViewById<Button>(R.id.btn_next_screen).setOnClickListener {
            val i = Intent(this, AdModAct::class.java)
            startActivity(i)
        }
    }
}