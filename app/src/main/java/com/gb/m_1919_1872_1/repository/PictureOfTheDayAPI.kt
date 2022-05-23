package com.gb.m_1919_1872_1.repository

import com.gb.m_1919_1872_1.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PictureOfTheDayAPI {
    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey:String): Call<PictureOfTheDayResponseData>
}