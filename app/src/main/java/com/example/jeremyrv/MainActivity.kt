package com.example.jeremyrv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var items:MutableList<Item> = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtNombre = findViewById<EditText>(R.id.txtNombre)
        var txtTipo = findViewById<EditText>(R.id.txtTipo)
        var txtEdad = findViewById<EditText>(R.id.txtEdad)
        var txtImage = findViewById<EditText>(R.id.txtImage)
        var btnGuardar = findViewById<Button>(R.id.btnGuardar)
        var btnIr = findViewById<Button>(R.id.btnIr)




        fun agregar(){
            val mascota = Item()
            mascota.nombre = txtNombre.text.toString()
            mascota.tipo = txtTipo.text.toString()
            mascota.edad = txtEdad.text.toString()
            mascota.image = txtImage.text.toString()
            items.add(mascota)
        }
        btnGuardar.setOnClickListener({
           agregar()
        })

        btnIr.setOnClickListener({

            val intent = Intent(this, activity2::class.java)
            intent.putExtra("mascotasList", ArrayList(items))
            startActivity(intent)
        })
    }
}