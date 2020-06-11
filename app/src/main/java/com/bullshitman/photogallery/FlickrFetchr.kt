package com.bullshitman.photogallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bullshitman.photogallery.Api.FlickrApi
import com.bullshitman.photogallery.Api.FlickrResponce
import com.bullshitman.photogallery.Api.PhotoResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "FlickrFetchr"

class FlickrFetchr  {
    private val flickrApi: FlickrApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        flickrApi = retrofit.create(FlickrApi::class.java)
    }
    fun fetchPhotos(): LiveData<List<GalleryItem>> {
        val responseLiveData: MutableLiveData<List<GalleryItem>> = MutableLiveData()
        val flickrRequest: Call<FlickrResponce> = flickrApi.fetchPhotos()
        flickrRequest.enqueue(object : Callback<FlickrResponce> {
            override fun onFailure(call: Call<FlickrResponce>, t: Throwable) {
                Log.e(TAG, "Failed to fetch photos", t)
            }

            override fun onResponse(call: Call<FlickrResponce>, response: Response<FlickrResponce>) {
                Log.d(TAG, "Response Received")
                val flickrResponce: FlickrResponce? = response.body()
                val photoResponce: PhotoResponce? = flickrResponce?.photos
                var galleryItems: List<GalleryItem> = photoResponce?.galleryItems ?: mutableListOf()
                galleryItems = galleryItems.filterNot { it.url.isBlank() }
                responseLiveData.value = galleryItems
            }
        })
        return responseLiveData
    }
}