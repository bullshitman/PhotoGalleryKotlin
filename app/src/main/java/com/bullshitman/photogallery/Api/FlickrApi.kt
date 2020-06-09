package com.bullshitman.photogallery.Api

import retrofit2.Call
import retrofit2.http.GET

interface FlickrApi {
    @GET("/")
    fun fetchContents(): Call<String>
}