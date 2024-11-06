package com.example.explorecsjdm

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DestinationDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_destination_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton: Button = findViewById(R.id.back_button)
        val backTextView: TextView = findViewById(R.id.back_txt)

        backButton.setOnClickListener {
            finish()
        }

        backTextView.setOnClickListener {
            finish()
        }

        val destinationName = intent.getStringExtra("DEST_NAME")
        val destinationDesc = intent.getStringExtra("DEST_DESC")
        val destinationLoc = intent.getStringExtra("DEST_LOC")
        val destinationImageResId = intent.getIntExtra("DEST_IMAGE", -1)

        val placeNameTextView: TextView = findViewById(R.id.place_name)
        val placeDescTextView: TextView = findViewById(R.id.place_desc)
        val placeLocTextView: TextView = findViewById(R.id.place_loc)
        val placeImageView: ImageView = findViewById(R.id.place_img)

        placeNameTextView.text = destinationName
        placeDescTextView.text = destinationDesc
        placeLocTextView.text = destinationLoc
        if (destinationImageResId != -1) {
            placeImageView.setImageResource(destinationImageResId)
        }
    }
}

