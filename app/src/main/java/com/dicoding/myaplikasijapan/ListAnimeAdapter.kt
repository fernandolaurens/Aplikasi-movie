package com.dicoding.myaplikasijapan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAnimeAdapter(private val listAnime: ArrayList<Anime>) : RecyclerView.Adapter<ListAnimeAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_anime, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, rating) = listAnime[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        // Set rating to RatingBar or other view
        holder.ratingBar.rating = rating

        // Add a click listener to the entire itemView
        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(listAnime[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listAnime.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val ratingBar: RatingBar = itemView.findViewById(R.id.rating_bar)
        val animeList = arrayListOf(
            Anime("Howls Moving Castle", "Deskripsi Howls Moving Castle", R.drawable.howel_movie, 4.0f),
            Anime("Josee, the Tiger and the Fish", "Deskripsi Josee, the Tiger and the Fish", R.drawable.josee_tsuneo, 3.5f),
            Anime("Jujutsu Kaisen", "Deskripsi Jujutsu Kaisen", R.drawable.jujutsu, 4.8f),
            Anime("A Silent Voice", "Deskripsi A Silent Voice", R.drawable.silent_vioce, 4.5f),
            Anime("Princess Mononoke", "Deskripsi Princess Mononoke", R.drawable.mononoke, 4.2f),
            Anime("Spirited Away", "Deskripsi Spirited Away", R.drawable.sprit_away, 4.9f),
            Anime("My Neighbor Totoro", "Deskripsi My Neighbor Totoro", R.drawable.totoro, 4.7f),
            Anime("Weathering with You", "Deskripsi Weathering with You", R.drawable.weathering, 4.5f),
            Anime("The Wind Rises", "Deskripsi The Wind Rises", R.drawable.wind_rise, 4.3f),
            Anime("Kimi No Na Wa", "Deskripsi Kimi No Na Wa", R.drawable.your_name, 4.6f)
        )

    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Anime)
    }
}