package com.dicoding.myaplikasijapan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAnimes: RecyclerView
    private val list = ArrayList<Anime>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAnimes = findViewById(R.id.rv_anime)
        rvAnimes.setHasFixedSize(true)
        list.addAll(getListAnimes())
        showRecyclerList()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                startActivity(Intent(this, aboutActivty::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListAnimes(): ArrayList<Anime> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataRating = resources.obtainTypedArray(R.array.data_rating)

        val listAnime = ArrayList<Anime>()

        for (i in dataName.indices) {
            val rating = dataRating.getFloat(i, 0.0f) // Menggunakan getFloat()
            val anime = Anime(
                dataName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1),
                rating
            )
            listAnime.add(anime)
        }

        // Pastikan untuk mendaur ulang TypedArray untuk menghindari memory leaks
        dataPhoto.recycle()
        dataRating.recycle()

        return listAnime
    }

    private fun showRecyclerList() {
        rvAnimes.layoutManager = LinearLayoutManager(this)
        val listAnimeAdapter = ListAnimeAdapter(list)
        rvAnimes.adapter = listAnimeAdapter

        listAnimeAdapter.setOnItemClickCallback(object : ListAnimeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Anime) {
                val moveWithDataIntent = Intent(this@MainActivity, detail::class.java)
                moveWithDataIntent.putExtra("EXTRA_NAME", data.name)
                moveWithDataIntent.putExtra("EXTRA_PHOTO", data.photo)
                moveWithDataIntent.putExtra("EXTRA_DESCRIPTION", data.description)
                moveWithDataIntent.putExtra("EXTRA_DESCRIPTION", data.description)
                moveWithDataIntent.putExtra("EXTRA_RATING", data.rating)
                startActivity(moveWithDataIntent)
            }
        })
    }



}