package com.techgirls.myapplication.service

import com.techgirls.myapplication.model.Contato
import retrofit2.Call
import retrofit2.http.GET

interface MyService {

    @GET("9cblp")
    fun listarContatos() : Call<List<Contato>>


}