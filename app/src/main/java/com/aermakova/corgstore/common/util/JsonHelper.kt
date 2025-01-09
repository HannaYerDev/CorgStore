package com.aermakova.corgstore.common.util

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

val json = Json {
    ignoreUnknownKeys = true
    encodeDefaults = true
}

val retrofitJsonConverter = json.asConverterFactory("application/json".toMediaType())
