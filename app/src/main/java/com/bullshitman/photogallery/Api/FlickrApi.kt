package com.bullshitman.photogallery.Api

import retrofit2.Call
import retrofit2.http.GET

interface FlickrApi {
    @GET("services/rest/?method=flickr.interestingness.getList" +
            "&api_key=3ef912a6c0791e15b992188bf1943e7d" +
            "&format=json" +
            "&nojsoncallback=1" +
            "&extras=url_s")
    fun fetchPhotos(): Call<FlickrResponce>
}