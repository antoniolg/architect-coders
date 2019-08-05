package com.antonioleiva.mymovies.utils

import android.content.Context
import okhttp3.mockwebserver.MockResponse
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets.UTF_8


fun MockResponse.fromJson(context: Context, jsonFile: String): MockResponse =
    setBody(readJsonFile(context, jsonFile))

private
fun readJsonFile(context: Context, jsonFilePath: String): String {
    val res = context.packageManager.getResourcesForApplication("com.antonioleiva.mymovies.test")

    var br: BufferedReader? = null

    try {
        br = BufferedReader(
            InputStreamReader(
                res.assets.open(
                    jsonFilePath
                ), UTF_8
            )
        )
        var line: String?
        val text = StringBuilder()

        do {
            line = br.readLine()
            line?.let { text.append(line) }
        } while (line != null)
        br.close()
        return text.toString()
    } finally {
        br?.close()
    }
}