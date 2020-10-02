package com.example.ayudadebaldor10.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.ayudadebaldor10.R
import kotlinx.android.synthetic.main.activity_segundo_inicio.*
import java.util.*
import kotlin.collections.ArrayList

class SegundoInicio : AppCompatActivity() {
    var chapter:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segundo_inicio)
        chapter = intent.getStringExtra("CHARPTER").toString()
        titleChapterSecondView.text = chapter.toString()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, readFileOptions())
        optionsList.adapter = adapter
        optionsList.setOnItemClickListener { adapterView, view, i, l -> goToTeoria(i) }
    }

    private fun readFileOptions(): ArrayList<String> {
        //abrir el archivo y leerlo
        val input = Scanner(resources.openRawResource(R.raw.options))
        val opciones = arrayListOf<String>()
        with(input) {
            while (input.hasNextLine()) {
                val line = nextLine()
                opciones.add(line)
            }
        }
        input.close()
        return opciones
    }

    private fun goToTeoria(i: Int) {
        val intent = Intent(this, Teoria::class.java)
        intent.putExtra("OPTION", readFileOptions()[i]+","+chapter)
        startActivity(intent)
    }
}