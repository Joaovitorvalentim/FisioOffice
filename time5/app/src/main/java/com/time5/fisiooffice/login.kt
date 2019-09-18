package com.time5.fisiooffice

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import fisiooffice.time5.fisiooffice.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Botão que passa para a tela inicial
        login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
