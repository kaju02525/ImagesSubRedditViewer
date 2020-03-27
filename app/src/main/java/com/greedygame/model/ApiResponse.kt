package com.greedygame.model
import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @SerializedName("data")
    var data: ChildrenData? = null
)

data class ChildrenData(
    @SerializedName("children")
    var children: List<Children>? = null
)

data class Children(
    @SerializedName("data")
    var thumbnailResponse: ThumbnailResponse? = null
)

data class ThumbnailResponse(
    @SerializedName("thumbnail")
    var thumbnail: String? = null
)