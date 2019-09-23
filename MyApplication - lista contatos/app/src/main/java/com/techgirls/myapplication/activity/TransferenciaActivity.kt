package com.techgirls.myapplication.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.botanju.myapplication.R
import com.techgirls.myapplication.model.Contato
import kotlinx.android.synthetic.main.activity_transferencia.*

class TransferenciaActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contato : Contato = intent.extras.getSerializable("contato") as Contato
        lbl_nome_contato.text = contato.nome
        lbl_banco_contato.text = contato.banco
        lbl_conta_contato.text = resources.getString(R.string.agencia_conta,  contato. agencia, contato.conta)

        btn_confirmar.setOnClickListener({

        })

    }

}