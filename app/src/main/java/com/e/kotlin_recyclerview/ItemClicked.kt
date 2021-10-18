package com.e.kotlin_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemClicked : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_clicked)
        var img:ImageView=findViewById(R.id.imageView)
        var text:TextView=findViewById(R.id.Description)

        var imageId=intent?.extras?.getInt("IMAGE")
        var titleText=intent?.extras?.getString("HEADLINE")
        if (imageId != null) {
            img.setImageResource(imageId)
        }
        text.text=titleText

    }
}