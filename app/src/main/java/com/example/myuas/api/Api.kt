package com.example.myuas.api

import com.example.myuas.model.BooksResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("data.php")
    fun getBooks(): Call<ArrayList<BooksResponse>>

    @GET("get_max_hits")
    fun getMaxHits(): Call<ArrayList<BooksResponse>>

    @GET("get_fav")
    fun getFav(): Call<ArrayList<BooksResponse>>

    @GET("get_new")
    fun getNew(): Call<ArrayList<BooksResponse>>

    @GET("get_thick")
    fun getThick(): Call<ArrayList<BooksResponse>>

}