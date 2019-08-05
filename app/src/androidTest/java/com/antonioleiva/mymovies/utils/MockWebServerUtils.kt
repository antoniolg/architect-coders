package com.antonioleiva.mymovies.utils

import androidx.test.platform.app.InstrumentationRegistry
import okhttp3.mockwebserver.MockResponse
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets.UTF_8


fun MockResponse.fromJson(jsonFile: String): MockResponse =
    setBody(readJsonFile(jsonFile))

private
fun readJsonFile(jsonFilePath: String): String {
    val context = InstrumentationRegistry.getInstrumentation().context

    var br: BufferedReader? = null

    try {
        br = BufferedReader(
            InputStreamReader(
                context.assets.open(
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