package com.example.kokkok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GiftInfoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gift_info_activity)
        supportActionBar?.hide()

    }
}