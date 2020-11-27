package com.example.prova01__16_11_2020

import com.example.prova01__16_11_2020.Sobremesas
import retrofit2.Call
import retrofit2.http.GET


interface ApiEndPoint {
    @GET("sobremesas")
    fun obterSobremesas(): Call<List<Sobremesas>>
}
