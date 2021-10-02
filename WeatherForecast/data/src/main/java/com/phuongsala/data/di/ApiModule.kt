package com.phuongsala.data.di

import android.content.Context
import com.google.gson.Gson
import com.phuongsala.data.BuildConfig
import com.phuongsala.data.BuildConfig.CONNECT_TIME
import com.phuongsala.data.BuildConfig.READ_TIME
import com.phuongsala.data.R
import com.phuongsala.data.api.ApiService
import com.phuongsala.data.entity.SSLCertificate
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideSSLCertificate(context: Context): SSLCertificate {
        return SSLCertificate(
            domain = context.getString(R.string.domain),
            cert1 = context.getString(R.string.cert1),
            cert2 = context.getString(R.string.cert2),
            cert3 = context.getString(R.string.cert3)
        )
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        sslCertificate: SSLCertificate
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .readTimeout(READ_TIME, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIME, TimeUnit.SECONDS)
            .certificatePinner(
                CertificatePinner.Builder()
                    .add(sslCertificate.domain, sslCertificate.cert1)
                    .add(sslCertificate.domain, sslCertificate.cert2)
                    .add(sslCertificate.domain, sslCertificate.cert3)
                    .build()
            )
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(httpLoggingInterceptor)
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}