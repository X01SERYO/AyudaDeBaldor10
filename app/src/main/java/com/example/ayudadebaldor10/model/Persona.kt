package com.example.ayudadebaldor10.model

class Persona(
    val nombre:String,
    val apellido:String,
    val edad: Int,
    val genero:String,
    val usuario:String,
    val contraseña:String
) {
    override fun toString(): String {
        return "$nombre $apellido $edad $genero $usuario $contraseña"
    }
}