package com.techgirls.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.botanju.myapplication.R
import com.techgirls.myapplication.model.Contato
import kotlinx.android.synthetic.main.item_contato_list.view.*

class ContatosAdapter (private val list: List<Contato>,
                       private val context: Context,
                       val clickListener: (Contato, Int) -> Unit
) : RecyclerView.Adapter<ContatosAdapter.ContatoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contato_list, parent, false)
        return ContatoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = list[position]
        holder.bindView(contato, clickListener, position)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ContatoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(
            contato: Contato,
            clickListener: (Contato, Int) -> Unit,
            position: Int
        ) {
            itemView.lbl_nome.text = contato.nome
            itemView.lbl_conta.text = itemView.context.resources.getString(R.string.agencia_conta,  contato. agencia, contato.conta)
            itemView.lbl_banco.text = contato.banco
            itemView.setOnClickListener({
                clickListener(contato, position)
            })
        }

    }
}