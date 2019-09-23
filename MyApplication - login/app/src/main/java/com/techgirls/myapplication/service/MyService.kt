package com.techgirls.myapplication.service

import com.techgirls.myapplication.model.Contato
import com.techgirls.myapplication.model.LoginResponse
import com.techgirls.myapplication.model.TransferenciaConfirmacao
import retrofit2.Call
import retrofit2.http.GET

interface MyService {

    @GET("19u7u1")
    fun login() : Call<LoginResponse>

    @GET("9cblp")
    fun listarContatos() : Call<List<Contato>>

    @GET("yeo65")
    fun fazerTransferencia() : Call<TransferenciaConfirmacao>

}