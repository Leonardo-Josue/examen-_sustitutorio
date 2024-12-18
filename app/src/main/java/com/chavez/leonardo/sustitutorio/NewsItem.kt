package com.chavez.leonardo.sustitutorio

import com.google.gson.annotations.SerializedName

data class NewsItem(
    val title: String,
    val description: String,
    @SerializedName("urlToImage") val image: String,
    val url: String
)
