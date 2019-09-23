package com.techgirls.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import com.botanju.myapplication.R
import com.techgirls.myapplication.model.Contato
import com.techgirls.myapplication.ContatosAdapter
import com.techgirls.myapplication.service.RetrofitInitialize
import kotlinx.android.synthetic.main.activity_contatos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaContatosActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contatos)

        buscaListaContatos()
    }

    private fun buscaListaContatos() {

        val call = RetrofitInitialize().myService().listarContatos()
        call.enqueue(object : Callback<List<Contato>?> {
            override fun onResponse(
                call: Call<List<Contato>?>?,
                response: Response<List<Contato>?>?
            ) {

                response?.body()?.let {
                   var listaContatos : List<Contato> = it
                    exibirLista(listaContatos)
                }
                Log.i("techgirl", "lista retornada com sucesso")
            }

            override fun onFailure(
                call: Call<List<Contato>?>?,
                t: Throwable?
            ) {
                Log.e("onFailure error", t?.message)
            }
        })

    }

    private fun exibirLista(listaContatos : List<Contato>) {
        rv_contatos.adapter = ContatosAdapter(listaContatos, this,
            { item: Contato, position: Int ->
            Log.e("ListaContatos", "Clicked on item  ${item.nome} at position $position")
                abrirTelaTransferencia(item)
        })

        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        rv_contatos.layoutManager = layoutManager
    }

    private fun abrirTelaTransferencia(item: Contato) {
        val intent = Intent(this, TransferenciaActivity::class.java)
            .putExtra("contato", item)
            .apply {  }

        startActivity(intent)
    }
}