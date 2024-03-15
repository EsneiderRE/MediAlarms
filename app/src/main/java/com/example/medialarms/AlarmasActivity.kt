package com.example.medialarms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ExpandableListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AlarmasActivity : AppCompatActivity() {

    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var grupoAlarmas : List<String>
    private lateinit var itemAlarmas : HashMap<String, List<String>>

    private lateinit var  listViewAlarmas : ExpandableListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_alarmas)
        showListAlarmas()

        listViewAdapter= ExpandableListViewAdapter(this, grupoAlarmas, itemAlarmas)

        listViewAlarmas=findViewById<ExpandableListView>(R.id.listViewAlarmas)
        listViewAlarmas.setAdapter(listViewAdapter)


        val btnVolver: Button =findViewById(R.id.buttonVolver)

        btnVolver.setOnClickListener {
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showListAlarmas() {
        grupoAlarmas=ArrayList()
        itemAlarmas= HashMap()

        (grupoAlarmas as ArrayList<String>).add("Medicamento X marca - 5...")
        (grupoAlarmas as ArrayList<String>).add("Medicamento Y marca - 2...")
        (grupoAlarmas as ArrayList<String>).add("Medicamento Z marca - 3...")

        val item1 : MutableList<String> = ArrayList()
        item1.add("Medicamento X marca - 500mg \nTipo de periodicidad: cada 2 horas \nCantidad: 2 \nObservacion: Tomar sin líquido")

        val item2 : MutableList<String> = ArrayList()
        item2.add("Medicamento Y marca - 200mg \nTipo de periodicidad: cada 8 horas \nCantidad: 3 \nObservacion: Tomar entre comidas")

        val item3 : MutableList<String> = ArrayList()
        item3.add("Medicamento Z marca - 300mg \nTipo de periodicidad: cada 12 horas \nCantidad: 2 \nObservacion: Tomar con ls comidas")

        itemAlarmas[grupoAlarmas[0]]=item1
        itemAlarmas[grupoAlarmas[1]]=item2
        itemAlarmas[grupoAlarmas[2]]=item3


    }
}