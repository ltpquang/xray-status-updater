package com.ltpquang.xray.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Quang Le (quangltp) on 7/25/20
 *
 */

data class TestRun(
    @SerializedName("id") val id : Int = 0,
    @SerializedName("status") val status : String = "",
    @SerializedName("color") val color : String = "",
    @SerializedName("testKey") val testKey : String = "",
    @SerializedName("testExecKey") val testExecKey : String = "",
    @SerializedName("executedBy") val executedBy : String = "",
    @SerializedName("startedOn") val startedOn : String = "",
    @SerializedName("finishedOn") val finishedOn : String = "",
    @SerializedName("startedOnIso") val startedOnIso : String = "",
    @SerializedName("finishedOnIso") val finishedOnIso : String = "",
    @SerializedName("duration") val duration : Int = 0,
    @SerializedName("defects") val defects : List<String> = emptyList(),
    @SerializedName("evidences") val evidences : List<String> = emptyList(),
    @SerializedName("scenarioOutline") val scenarioOutline : String = "",
    @SerializedName("examples") val examples : List<Example> = emptyList(),
    @SerializedName("testEnvironments") val testEnvironments : List<String> = emptyList(),
    @SerializedName("fixVersions") val fixVersions : List<FixVersion> = emptyList()
) {
    class Deserialize
}
