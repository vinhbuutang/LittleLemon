package com.example.littlelemon

import android.content.Context
import androidx.annotation.StringRes

class ResourceProvider(private val context: Context) {
    fun getString(@StringRes id: Int): String = context.getString(id)
}