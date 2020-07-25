package com.ltpquang.xray.client

import com.ltpquang.xray.models.Status
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import java.net.URL

/**
 * Created by Quang Le (quangltp) on 7/25/20
 *
 */

class XrayUrl(base: String) {
    private val httpUrl = base.toHttpUrlOrNull()!!.newBuilder()
        .addPathSegments("rest/raven/1.0/api")
        .build()

    fun getTestRunUrl(testIssueKey: String, testExecIssueKey: String): HttpUrl {
        return httpUrl.newBuilder()
            .addPathSegment("testrun")
            .addQueryParameter("testIssueKey", testIssueKey)
            .addQueryParameter("testExecIssueKey", testExecIssueKey)
            .build()
    }

    fun updateTestRunStatusUrl(testRunId: Int, status: Status): HttpUrl {
        return httpUrl.newBuilder()
            .addPathSegment("testrun")
            .addPathSegment(testRunId.toString())
            .addPathSegment("status")
            .addQueryParameter("status", status.toString())
            .build()
    }
}
