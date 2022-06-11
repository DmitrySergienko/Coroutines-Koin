package com.example.coroutines_koin

import android.content.Context

class SomeClassContext(private val context: Context) {
    fun print() {
        println("VVV ${context.getString(R.string.app_name)}")
    }
}