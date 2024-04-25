package com.example.jeremyrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(var datos:MutableList<Item>) : RecyclerView.Adapter<Adapter.MiViewHolder>() {
    class MiViewHolder(view: View): RecyclerView.ViewHolder(view){
        var txtNombre = view.findViewById<TextView>(R.id.textView)
        var txtEdad = view.findViewById<TextView>(R.id.textView3)
        var txtTipo = view.findViewById<TextView>(R.id.textView2)
        var txtImage = view.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {
        var viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MiViewHolder(viewItem)

    }

    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        holder.txtNombre.text = datos[position].nombre
        holder.txtTipo.text =datos[position].tipo
        holder.txtEdad.text = datos[position].edad
        LoadImageTask(holder.txtImage).execute(datos[position].image)
    }

    override fun getItemCount(): Int {
        return datos.size    }

}