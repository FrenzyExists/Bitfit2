package com.codepath.articlesearch

import android.app.Application

class AppApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}