package com.example.projectuts

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projectuts.Fragment.HomeFragment

class DetailPixelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pixel)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val Pixel = intent.getParcelableExtra<Pixel>(HomeFragment.INTENT_PARCELABLE)

        val imagePixel = findViewById<ImageView>(R.id.img_item_photo)
        val namePixel = findViewById<TextView>(R.id.tv_item_name)
        val descPixel = findViewById<TextView>(R.id.tv_item_description)

        imagePixel.setImageResource(Pixel?.imagePixel!!)
        namePixel.text = Pixel.namePixel
        descPixel.text = Pixel.descPixel
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }
}