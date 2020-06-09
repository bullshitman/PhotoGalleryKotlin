package com.bullshitman.photogallery.Api

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "FlickrFetchr"

class FlickrFetchr  {
    private val flickrApi: FlickrApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.flickr.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        flickrApi = retrofit.create(FlickrApi::class.java)
    }
}