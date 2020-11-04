package com.ltpquang.xray.client

import com.google.gson.Gson
import com.ltpquang.xray.models.Status
import com.ltpquang.xray.models.TestRun
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.EMPTY_REQUEST
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Quang Le (quangltp) on 7/25/20
 *
 */

class XrayClient(host: String, username: String, password: String) {
    private val xrayUrl = XrayUrl(host)
    private val client: OkHttpClient

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)

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
            .addInterceptor(logging)
            .build()
    }

    fun setStatus(testIssueKey: String, testExecIssueKey: String, status: Status) {
        val testRun = getTestRun(testIssueKey, testExecIssueKey) ?: return
        setTestRunStatus(testRun.id, status)
    }

    private fun getTestRun(testIssueKey: String, testExecIssueKey: String): TestRun? {
        try {
            val req = Request.Builder()
                .get()
                .url(xrayUrl.getTestRunUrl(testIssueKey, testExecIssueKey))
                .build()
            val res = client.newCall(req).execute()
            if (res.code != 200) {
                return null
            }
            return Gson().fromJson(res.body!!.charStream(), TestRun::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    private fun setTestRunStatus(id: Int, status: Status) {
        try {
            val req = Request.Builder()
                .put(EMPTY_REQUEST)
                .url(xrayUrl.updateTestRunStatusUrl(id, status))
                .build()
            client.newCall(req).execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
