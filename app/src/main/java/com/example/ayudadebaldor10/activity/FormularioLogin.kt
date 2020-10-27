package com.example.ayudadebaldor10.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.get
import com.example.ayudadebaldor10.R
import com.example.ayudadebaldor10.model.Persona
import kotlinx.android.synthetic.main.activity_formulario_login.*

class FormularioLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_login)
        registraseButtom.setOnClickListener { v-> onClickRegistrarse(v) }
    }
    fun onClickRegistrarse(v : View){
        var sexo=""
        var errorMensaje=""
        var correcto=0
        if(radioButtonMasculino.isChecked){
            sexo=radioButtonMasculino.text.toString()
        }else if(radioButtonFemenino.isChecked){
            sexo=radioButtonFemenino.text.toString()
        }
        if(contraseña.text.toString()==confirmarContraseña.text.toString())
        {
            when{
                nombre.text.isEmpty()-> errorMensaje+="El nombre es obligatorio \n"
                apellido.text.isEmpty()->errorMensaje+="El apellido es obligatorio \n"
                edad.text.isEmpty()->errorMensaje+="La edad es obligatorio \n"
                sexo==""->errorMensaje+="Debe seleccionar su género \n"
                usuario.text.isEmpty()-> errorMensaje+="El usuario es obligatorio \n"
                contraseña.text.isEmpty()-> errorMensaje+="La contraseña es obligatoria \n"
                confirmarContraseña.text.isEmpty()-> errorMensaje+="Debe confirmar la contraseña \n"
            }
        }else{
            errorMensaje+="Las contraseñas no coinciden \n"
        }
        error.text=errorMensaje
        if(errorMensaje==""){
            val persona = Persona(
                nombre.text.toString(),
                apellido.text.toString(),
                edad.text.toString().toInt(),
                sexo,
                usuario.text.toString(),
                contraseña.text.toString()
            )
            Log.v("CONSOLA",persona.toString())
        }
    }
}