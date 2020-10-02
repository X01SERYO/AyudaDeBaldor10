package com.example.ayudadebaldor10.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.ayudadebaldor10.R
import com.example.ayudadebaldor10.model.Capitulo

class CapituloAdapter(context: Context, val resource: Int, val data: ArrayList<Capitulo>) :
    ArrayAdapter<Capitulo>(context, resource, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return createViewFromResource(inflater, position, convertView, parent);
    }

    private fun createViewFromResource(
        inflater: LayoutInflater,
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        // 1. lookup the data we want to show
        val capitulo = data[position]
        // 2. choose the view components we want to use
        val view: View = convertView ?: inflater.inflate(resource, parent, false)
        val numberCharpter = view.findViewById<TextView>(R.id.numberChapter)
        numberCharpter.text = capitulo.number.toString()
        val titleChapter = view.findViewById<TextView>(R.id.titleChapter)
        titleChapter.text = "Capítulo ${capitulo.number}"
        val nameChapter = view.findViewById<TextView>(R.id.nameChapter)
        nameChapter.text = capitulo.name
        val descriptionChapter = view.findViewById<TextView>(R.id.descriptionChapter)
        descriptionChapter.text = capitulo.description
        // 3. return the new view

        return view

    }

}