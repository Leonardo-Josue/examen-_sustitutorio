package com.chavez.leonardo.sustitutorio

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("top-headlines?country=us&apiKey=8711301dd46f4447ac9ae4310c627fe0")
    fun getTopHeadlines(): Call<NewsResponse>
}
