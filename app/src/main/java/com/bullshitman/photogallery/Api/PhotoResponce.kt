package com.bullshitman.photogallery.Api

import com.bullshitman.photogallery.GalleryItem
import com.google.gson.annotations.SerializedName

class PhotoResponce {
    @SerializedName("photo") lateinit var galleryItems: List<GalleryItem>
}