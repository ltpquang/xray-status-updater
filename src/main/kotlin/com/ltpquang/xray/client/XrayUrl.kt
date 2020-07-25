package com.ltpquang.xray.client

import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import java.net.URL

/**
 * Created by Quang Le (quangltp) on 7/25/20
 *
 */

class XrayUrl(base: String) {

    private val httpBuilder = base.toHttpUrlOrNull()!!.newBuilder()
        .addPathSegments("rest/raven/1.0/api")

    fun getTestRun(testIssueKey: String, testExecIssueKey: String): HttpUrl {
        return httpBuilder
            .addPathSegment("testrun")
            .addQueryParameter("testIssueKey", testIssueKey)
            .addQueryParameter("testExecIssueKey", testExecIssueKey)
            .build()
    }

}
