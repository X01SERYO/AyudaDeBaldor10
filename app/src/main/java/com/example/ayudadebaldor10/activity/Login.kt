package com.example.ayudadebaldor10.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ayudadebaldor10.R

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onClickIngresar(v: View) {
        //cambio de activyty de Login a Inicio
        val intent = Intent(this, Inicio::class.java).apply {
        }
        startActivity(intent)
    }
    fun onClickResgistrse(v: View) {
        //cambio de activyty de Login a FormularioLogin
        val intent = Intent(this, FormularioLogin::class.java).apply {
        }
        startActivity(intent)
    }
}