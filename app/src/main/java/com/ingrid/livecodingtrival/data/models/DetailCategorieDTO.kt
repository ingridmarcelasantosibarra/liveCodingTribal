package com.ingrid.livecodingtrival.data.models

import com.google.gson.annotations.SerializedName

data class DetailCategorieDTO(
    @SerializedName("value") val value : String = "",
    @SerializedName("url") val url : String = ""
)
