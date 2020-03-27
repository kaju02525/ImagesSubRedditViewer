package com.greedygame.utils

import android.content.Context
import java.io.File

class FileCache(context: Context) {
    private var cacheDir: File? = null
    fun getFile(url: String): File {
        val filename = url.hashCode().toString()
        return File(cacheDir, filename)
    }

    init {
        cacheDir=context.cacheDir
        if (!cacheDir!!.exists()) cacheDir!!.mkdirs()
    }
}