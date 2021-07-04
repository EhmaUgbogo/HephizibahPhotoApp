package com.ehmaugbogo.hephizibahapp.di

import com.ehmaugbogo.hephizibahapp.BuildConfig
import com.ehmaugbogo.hephizibahapp.api.PicSumApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * @company ..: GIGM
 * @author ..: Ehma Ugbogo
 * @email ..: ehmaugbogo@gmail.com
 * @created ..: 04-07-2021
 */

private const val duration = 20L
private const val BASE_URL = "https://picsum.photos/v2/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val builder = OkHttpClient.Builder()
            .callTimeout(duration, TimeUnit.SECONDS)
            .readTimeout(duration, TimeUnit.SECONDS)
            .writeTimeout(duration, TimeUnit.SECONDS)

        if(BuildConfig.DEBUG) builder.addInterceptor(interceptor)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePicSumApi(retrofit: Retrofit) = retrofit.create(PicSumApi::class.java)

}