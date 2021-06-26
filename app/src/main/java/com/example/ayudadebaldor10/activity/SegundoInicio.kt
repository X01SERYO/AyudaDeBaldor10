package com.example.ayudadebaldor10.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.ayudadebaldor10.R
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_segundo_inicio.*
import java.util.*
import kotlin.collections.ArrayList

class SegundoInicio : AppCompatActivity() {
    var chapter: String = ""
    val API_KEY = "AIzaSyDxbWs9zY9ilSxIGLQZKcimGq9OTXaPt8I"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segundo_inicio)
        chapter = intent.getStringExtra("CHARPTER").toString()
        titleChapterSecondView.text = chapter
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

    private fun readFileVideo(): String {
        //abrir el archivo y leerlo
        val input = Scanner(resources.openRawResource(R.raw.videos))
        var video = ""
        with(input) {
            while (input.hasNextLine()) {
                val line = nextLine()
                val topic = line.split(",")
                if (topic[0] == replaceVowels(chapter)) {
                    video = topic[1]
                    return video
                }
            }
        }
        input.close()

        return video
    }

    private fun replaceVowels(word: String): String {
        var newWord: String = word.replace("á", "a")
        newWord = newWord.replace("é", "e")
        newWord = newWord.replace("í", "i")
        newWord = newWord.replace("ó", "o")
        newWord = newWord.replace("ú", "u")
        return newWord

    }

    private fun goToTeoria(i: Int) {
        //Log.v("CONSOLA", i.toString())
        if (i == 0 || i == 1) {
            val intent = Intent(this, TeoriaOEjemplos::class.java)
            intent.putExtra("OPTION", readFileOptions()[i] + "," + chapter)
            startActivity(intent)
        }
        if (i == 2) {
            val intent = Intent(this, Ejercicios::class.java)
            intent.putExtra("OPTION", readFileOptions()[i] + "," + chapter)
            startActivity(intent)
        }
        if (i == 3) {
            val video = readFileVideo()
//            val intentVideo= YouTubeStandalonePlayer.createVideoIntent(this,API_KEY,video)
//            startActivity(intentVideo)
            val intent =YouTubeStandalonePlayer.createVideoIntent(this, API_KEY, video, 0, true, false)
            startActivity(intent)
        }
    }
}