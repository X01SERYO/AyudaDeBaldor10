package com.example.ayudadebaldor10.activity

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ayudadebaldor10.R
import kotlinx.android.synthetic.main.activity_teoria.*
import java.util.*

class Teoria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teoria)
        val intent = intent.getStringExtra("OPTION")
        val line= intent?.split(",")
        titleTeoria.text = line!![0]
        titleChapterSecondView.text = line!![1]
        content.text=readFileTxt(line!![1],line!![0])
    }

    private fun readFileTxt(first: String, second : String): String {
        var parrafo: String = ""
        var name=first+"_"+second
        name =replaceVowels(name.toLowerCase())
        val file = this.resources.getIdentifier(name, "raw", this.packageName)
        val input = Scanner(resources.openRawResource(file))
        with(input) {
            while (input.hasNextLine()) {
                val line = nextLine()
                parrafo+=(line)+"\n"+"\n"
            }
        }
        input.close()
        return parrafo
    }
    private fun replaceVowels(word: String): String {
        var newWord: String = word.replace("á","a")
        newWord=newWord.replace("é","e")
        newWord=newWord.replace("í","i")
        newWord=newWord.replace("ó","o")
        newWord=newWord.replace("ú","u")
        newWord=newWord.replace("Á","a")
        newWord=newWord.replace("É","e")
        newWord=newWord.replace("Í","i")
        newWord=newWord.replace("Ó","o")
        newWord=newWord.replace("Ú","u")
        newWord=newWord.replace(" ","_")
        return newWord

    }
}