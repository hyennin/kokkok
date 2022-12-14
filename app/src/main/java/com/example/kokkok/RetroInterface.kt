package com.example.kokkok

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetroInterface{
    @POST("/register")
    @Headers("accept: application/json",
        "content-type: application/json")
    fun register(
        @Body jsonparams: RegisterModel
    ) : Call<RegisterResult>

    @POST("/login")
    fun login(
        @Body jsonparams: LoginModel
    ) : Call<LoginResult>

    @GET("/users_info")
    fun allUser(): Call<ArrayList<User>>

    @POST("/getUserId")
    fun getUserId(
        @Body jsonparams: LoginResult
    ): Call<ArrayList<UserId>>


    companion object { // static 처럼 공유객체로 사용가능함. 모든 인스턴스가 공유하는 객체로서 동작함.
        private const val BASE_URL = "http://10.96.120.121:8444" //

        fun create(): RetroInterface {
            val gson : Gson =   GsonBuilder().setLenient().create();

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(RetroInterface::class.java)
        }
    }
}