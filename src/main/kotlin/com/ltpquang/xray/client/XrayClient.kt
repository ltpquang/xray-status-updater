package com.ltpquang.xray.client

import com.google.gson.Gson
import com.ltpquang.xray.models.Status
import com.ltpquang.xray.models.TestRun
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.EMPTY_REQUEST


/**
 * Created by Quang Le (quangltp) on 7/25/20
 *
 */

class XrayClient(host: String, username: String, password: String) {
    private val xrayUrl = XrayUrl(host)
    private val client: OkHttpClient

    init {
        client = OkHttpClient.Builder()
            .addInterceptor { chain: Interceptor.Chain ->
                val req = chain.request()
                val credential = Credentials.basic(username, password)
                val authReq = req.newBuilder()
                    .addHeader("Authorization", credential)
                    .addHeader("Content-Type", "application/json")
                    .build()
                return@addInterceptor chain.proceed(authReq)
            }
            .build()
    }

    private fun getTestRun(testIssueKey: String, testExecIssueKey: String): TestRun {
        val req = Request.Builder()
            .get()
            .url(xrayUrl.getTestRunUrl(testIssueKey, testExecIssueKey))
            .build()
        val res = client.newCall(req).execute()
        val result = Gson().fromJson(res.body!!.charStream(), TestRun::class.java)
        print(result)
        return result
    }

    private fun setTestRunStatus(id: Int, status: Status) {
        val req = Request.Builder()
            .put(EMPTY_REQUEST)
            .url(xrayUrl.updateTestRunStatusUrl(id, status))
            .build()
        val res = client.newCall(req).execute()
    }

    fun setStatus(testIssueKey: String, testExecIssueKey: String, status: Status) {
        val testRun = getTestRun(testIssueKey, testExecIssueKey)
        setTestRunStatus(testRun.id, status)
    }
}
