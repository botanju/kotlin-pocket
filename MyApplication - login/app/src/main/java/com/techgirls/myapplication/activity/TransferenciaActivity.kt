package com.techgirls.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.botanju.myapplication.R
import com.techgirls.myapplication.model.Contato
import com.techgirls.myapplication.model.TransferenciaConfirmacao
import com.techgirls.myapplication.service.RetrofitInitialize
import kotlinx.android.synthetic.main.activity_transferencia.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransferenciaActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transferencia)

        val contato : Contato = intent.extras.getSerializable("contato") as Contato

        btn_confirmar.setOnClickListener({
            fazerTransferencia()
        })

        carregaDadosContato(contato)

    }

    private fun carregaDadosContato(contato: Contato) {
        lbl_nome_contato.text = contato.nome
        lbl_banco_contato.text = contato.banco
        lbl_conta_contato.text = resources.getString(R.string.agencia_conta,  contato.agencia, contato.conta)
    }


    private fun fazerTransferencia() {
        val call = RetrofitInitialize().myService().fazerTransferencia()
        call.enqueue(object : Callback<TransferenciaConfirmacao?> {
            override fun onResponse(
                call: Call<TransferenciaConfirmacao?>?,
                response: Response<TransferenciaConfirmacao?>?
            ) {

                response?.body()?.let {
                   abrirComprovante(it)
                }

                Log.i("techgirl", "transferencia feita com sucesso")

            }

            override fun onFailure(
                call: Call<TransferenciaConfirmacao?>?,
                t: Throwable?
            ) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    private fun abrirComprovante(comprovante: TransferenciaConfirmacao) {
        val intent = Intent(this, ComprovanteActivity::class.java)
            .putExtra("comprovante", comprovante)
            .apply {  }

        startActivity(intent)
    }
}