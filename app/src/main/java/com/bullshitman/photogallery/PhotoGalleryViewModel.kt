package com.bullshitman.photogallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

private const val TAG = "ViewModel"

class PhotoGalleryViewModel: ViewModel() {
    val galleryItemLiveData: LiveData<List<GalleryItem>>

    init {
        galleryItemLiveData = FlickrFetchr().fetchPhotos()
        Log.d(TAG, "ViewModel created")
    }
}