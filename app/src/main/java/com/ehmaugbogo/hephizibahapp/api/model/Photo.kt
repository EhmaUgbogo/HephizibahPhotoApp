package com.ehmaugbogo.hephizibahapp.api.model


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    var id: String = "",
    @SerializedName("author")
    var author: String = "",
    @SerializedName("width")
    var width: Int = 0,
    @SerializedName("height")
    var height: Int = 0,
    @SerializedName("url")
    var url: String = "",
    @SerializedName("download_url")
    var downloadUrl: String = ""
)