package com.example.hiltroommvvm.data.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RetrofitApp @Inject constructor() {

    companion object {
        /*
       * Live
       * */
        //private const val BASE_URL =  "http://184.95.32.186/HGR2.1/Webservice/HGRmobileServices.asmx/UserStudentLogin?UserName=U041915&PassWord=U041915&CollegeCode=MKJCVD"
        private const val BASE_URL =
            "http://184.95.32.186/HGR2.1/Webservice/HGRmobileServices.asmx/"
    }

    private val okHttp: OkHttpClient by lazy {
/*        if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS) //Get debugger info
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        } else {
            OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
        }*/

        OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private val gson: Gson by lazy {
        GsonBuilder()
            .setLenient()
            .create()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiHelper: ApiHelper by lazy {
        retrofit.create(ApiHelper::class.java)
    }


}