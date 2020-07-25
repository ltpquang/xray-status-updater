package com.ltpquang.xray.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Quang Le (quangltp) on 7/25/20
 *
 */

data class FixVersion(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("isArchived") val isArchived: Boolean,
    @SerializedName("isReleased") val isReleased: Boolean
)
