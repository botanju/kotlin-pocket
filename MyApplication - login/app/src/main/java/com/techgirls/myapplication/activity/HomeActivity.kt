package com.techgirls.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.botanju.myapplication.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_contatos.setOnClickListener({
            val intent = Intent(this, ListaContatosActivity::class.java).apply{}
            startActivity(intent)
        })

    }
}