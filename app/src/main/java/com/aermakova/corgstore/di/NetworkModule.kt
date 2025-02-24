package com.aermakova.corgstore.di

import com.aermakova.corgstore.BuildConfig
import com.aermakova.corgstore.common.util.Environment
import com.aermakova.corgstore.common.util.retrofitJsonConverter
import com.aermakova.corgstore.data.remote.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttp(
        apiKeyInterceptor: ApiKeyInterceptor,
        queryInterceptor: QueryInterceptor
    ): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(apiKeyInterceptor)
        .addInterceptor(queryInterceptor)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit
        .Builder()
        .baseUrl(Environment.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(retrofitJsonConverter)
        .build()

    @Provides
    @Singleton
    fun provideProductApi(
        retrofit: Retrofit
    ): ProductApi = retrofit.create()
}

@Singleton
class ApiKeyInterceptor @Inject constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val requestWithUserAgent: Request = originalRequest
            .newBuilder()
            .header(API_KEY_HEADER, BuildConfig.API_KEY)
            .build()
        return chain.proceed(requestWithUserAgent)
    }
}

@Singleton
class QueryInterceptor @Inject constructor(

) : Interceptor {
    @Throws(IOException::class)

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest: Request = chain.request()
        val newUrl = originalRequest
            .url
            .newBuilder()
            .addQueryParameter(COUNTRY_CODE, "us")
            .addQueryParameter(LANGUAGE_CODE, "en")
            .build()

        val requestWithNewUrl: Request = originalRequest
            .newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(requestWithNewUrl)
    }
}

internal const val API_KEY_HEADER = "x-rapidapi-key"
internal const val COUNTRY_CODE = "countryCode"
internal const val LANGUAGE_CODE = "languageCode"
