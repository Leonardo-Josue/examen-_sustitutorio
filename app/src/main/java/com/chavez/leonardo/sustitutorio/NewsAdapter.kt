package com.chavez.leonardo.sustitutorio

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chavez.leonardo.sustitutorio.databinding.ItemsNewsBinding

class NewsAdapter(private val context: Context, private val newsList: List<NewsItem>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(val binding: ItemsNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemsNewsBinding.inflate(LayoutInflater.from(context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        with(holder.binding) {
            newsTitle.text = news.title
            newsDescription.text = news.description
            Glide.with(newsImage.context)
                .load(news.image)
                .into(newsImage)
            root.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("title", news.title)
                    putExtra("description", news.description)
                    putExtra("url", news.url)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = newsList.size
}
