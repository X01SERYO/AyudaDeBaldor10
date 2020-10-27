package com.example.ayudadebaldor10.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ayudadebaldor10.R
import com.example.ayudadebaldor10.model.Pregunta
import kotlinx.android.synthetic.main.activity_teoria.titleChapterSecondView
import kotlinx.android.synthetic.main.activity_teoria.titleTeoria
import java.util.*


class Ejercicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios)
        val intent = intent.getStringExtra("OPTION")
        val line = intent?.split(",")
        titleTeoria.text = line!![0]
        titleChapterSecondView.text = line!![1]
        val preguntas=readFileEjercicios(line!![1], line!![0])
        for(position in preguntas.indices){
            if(preguntas[position].tipo=="radio"){

            }
            if(preguntas[position].tipo=="abierta"){

            }
        }
    }


    private fun readFileEjercicios(first: String, second: String): ArrayList<Pregunta> {
        var name = first + "_" + second
        name = replaceVowels(name.toLowerCase())
        val file = this.resources.getIdentifier(name, "raw", this.packageName)

        val input = Scanner(resources.openRawResource(file))
        val preguntas = arrayListOf<Pregunta>()
        with(input) {
            while (input.hasNextLine()) {
                val line = nextLine()
                val data = line.split(",")
                val pregunta = Pregunta(
                    data[0],
                    data[1],
                    data[2],
                    data[3],
                    data[4],
                )
                preguntas.add(pregunta)
            }
        }

        input.close()
        return preguntas
    }


    private fun replaceVowels(word: String): String {
        var newWord: String = word.replace("á", "a")
        newWord = newWord.replace("é", "e")
        newWord = newWord.replace("í", "i")
        newWord = newWord.replace("ó", "o")
        newWord = newWord.replace("ú", "u")
        newWord = newWord.replace(" ", "_")
        return newWord

    }
}