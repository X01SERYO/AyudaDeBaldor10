package com.example.ayudadebaldor10.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ayudadebaldor10.adapter.CapituloAdapter
import com.example.ayudadebaldor10.R
import com.example.ayudadebaldor10.model.Capitulo
import kotlinx.android.synthetic.main.activity_inicio.*
import java.util.*
import kotlin.collections.ArrayList


class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val adapter = CapituloAdapter(this, R.layout.lista_capitulos, readFile())
        chapterList.adapter = adapter
        chapterList.setOnItemClickListener { adapterView, view, i, l -> goToSegundoInicio(i) }
    }

    private fun readFile(): ArrayList<Capitulo> {
        //abrir el archivo y leerlo
        val input = Scanner(resources.openRawResource(R.raw.general_list_baldor))
        val capitulos = arrayListOf<Capitulo>()
        with(input) {
            while (input.hasNextLine()) {
                val line = nextLine()
                val data = line.split(",")
                val capitulo = Capitulo(
                    data[0].toInt(),
                    data[1],
                    data[2]
                )
                capitulos.add(capitulo)
            }
        }
        input.close()
        return capitulos
    }

    private fun goToSegundoInicio(i: Int) {
        val intent = Intent(this, SegundoInicio::class.java)
        intent.putExtra("CHARPTER", readFile()[i].name)
        startActivity(intent)
    }
}