package com.dicoding.myaplikasijapan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class detail : AppCompatActivity() {
    private val EXTRA_NAME = "EXTRA_NAME"
    private val EXTRA_PHOTO = "EXTRA_PHOTO"
    private val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"
    private val EXTRA_RATING ="EXTRA_RATING"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Get data from the intent
        val animeName = intent.getStringExtra(EXTRA_NAME)
        val animeDescription = intent.getStringExtra(EXTRA_DESCRIPTION)
        val animeImageResource = intent.getIntExtra(EXTRA_PHOTO, 0)
        val animeRating = intent.getFloatExtra(EXTRA_RATING, 0.0f)

        // Find views
        val ivAnimeImage = findViewById<ImageView>(R.id.img_item_photo)
        val tvAnimeName = findViewById<TextView>(R.id.rv_anime)
        val tvAnimeDescription = findViewById<TextView>(R.id.rv_anime_description)
        val ratingBar = findViewById<RatingBar>(R.id.rating_bar)


        // Set data to views
        ivAnimeImage.setImageResource(animeImageResource)
        tvAnimeName.text = animeName
        tvAnimeDescription.text = animeDescription

        // Set RatingBar properties or handle changes as needed
        // For example, set a default rating
        ratingBar.rating = animeRating


        }
    }
