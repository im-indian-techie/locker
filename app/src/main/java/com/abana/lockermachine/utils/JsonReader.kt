package com.abana.lockermachine.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.io.IOException
import java.io.InputStream


class JsonReader {
    fun getJsonObjectFromAssets(context:Context,filename:String): JsonObject? {
        var json: String? = null
        try {
            val inputStream: InputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return Gson().fromJson(json,JsonObject::class.java)
    }
}