package com.sporttest.gymapp.network

import com.sporttest.gymapp.BuildConfig
import com.sporttest.gymapp.network.login.LoginDto
import com.sporttest.gymapp.network.login.TokenDto
import com.sporttest.gymapp.network.workout.WorkoutResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitHelper {

    @POST("getList_dummy")
    suspend fun getWorkouts(@Query("page") page: Int, @Query("limit") limit: Int): WorkoutResponse

    @POST("login_dummy")
    suspend fun login(@Body loginDto: LoginDto) : Response<TokenDto>

    companion object {

        private const val BASE_URL = "http://77.232.37.44:8080/"

        operator fun invoke(): RetrofitHelper {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getRetrofitClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitHelper::class.java)
        }

        private fun getRetrofitClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor { chain ->
                    chain.proceed(chain.request().newBuilder().also {
                        it.addHeader("Accept", "application/json")
                        it.addHeader("Content-Type", "application/json")
                    }.build())
                }.also { client ->
                    if (BuildConfig.DEBUG) {
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
                }.build()
        }
    }

}