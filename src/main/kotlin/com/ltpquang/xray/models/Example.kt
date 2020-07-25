package com.ltpquang.xray.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Quang Le (quangltp) on 7/25/20
 *
 */

data class Example(
    @SerializedName("id") val id : Int,
    @SerializedName("rank") val rank : Int,
    @SerializedName("values") val values : List<String>,
    @SerializedName("status") val status : String,
    @SerializedName("duration") val duration : String,
    @SerializedName("backgrounds") val backgrounds : List<String>,
    @SerializedName("hooks") val hooks : List<String>,
    @SerializedName("steps") val steps : List<String>
)
