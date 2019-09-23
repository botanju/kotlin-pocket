package com.techgirls.myapplication.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.botanju.myapplication.R
import com.techgirls.myapplication.model.TransferenciaConfirmacao
import kotlinx.android.synthetic.main.activity_comprovante.*

class ComprovanteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprovante)

        val comprovante : TransferenciaConfirmacao = intent.extras.getSerializable("comprovante")
                as TransferenciaConfirmacao

        carregaDadosComprovante(comprovante)

    }

    private fun carregaDadosComprovante(comprovante: TransferenciaConfirmacao) {
        lbl_nome_contato.text = resources.getString(R.string.nome, comprovante.recebedor.nome)
        lbl_banco.text =  comprovante.recebedor.banco
        lbl_conta.text = resources.getString(R.string.agencia_conta,  comprovante.recebedor.agencia,
            comprovante.recebedor.conta)
        lbl_valor.text = resources.getString(R.string.valor_com_label, comprovante.valor)
        lbl_data_tranf.text = resources.getString(R.string.data_transferencia, comprovante.dataTransferencia)
        lbl_comprovante.text = resources.getString(R.string.comprovante_label, comprovante.comprovanteId)
        lbl_mensagem.text = comprovante.mensagem
    }

}
