package com.example.medialarms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ExpandableListView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity


class MedicamentosActivity : AppCompatActivity() {

    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var grupoAlarmas : List<String>
    private lateinit var itemAlarmas : HashMap<String, List<String>>

    private lateinit var  listViewAlarmas : ExpandableListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_medicamentos)

        showListMedicamentos()

        listViewAdapter= ExpandableListViewAdapter(this, grupoAlarmas, itemAlarmas)

        listViewAlarmas=findViewById<ExpandableListView>(R.id.listViewMedicamentos)
        listViewAlarmas.setAdapter(listViewAdapter)

        val btnVolver: Button =findViewById(R.id.buttonVolver)

        btnVolver.setOnClickListener {
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun showListMedicamentos() {
        grupoAlarmas=ArrayList()
        itemAlarmas= HashMap()

        (grupoAlarmas as ArrayList<String>).add("Medicamento X marca - 5...")
        (grupoAlarmas as ArrayList<String>).add("Medicamento Y marca - 2...")
        (grupoAlarmas as ArrayList<String>).add("Medicamento Z marca - 3...")

        val item1 : MutableList<String> = ArrayList()
        item1.add("Medicamento X marca - 500mg \nÚltima compra: 20/02/2024 \nUnidades disponibles: 20 \nFinaliza en : 10 días")

        val item2 : MutableList<String> = ArrayList()
        item2.add("Medicamento Y marca - 200mg \nÚltima compra: 12/01/2024 \nUnidades disponibles: 23 \nFinaliza en : 40 días")

        val item3 : MutableList<String> = ArrayList()
        item3.add("Medicamento Z marca - 300mg \nÚltima compra: 04/03/2024 \nUnidades disponibles: 17 \nFinaliza en : 20 días")

        itemAlarmas[grupoAlarmas[0]]=item1
        itemAlarmas[grupoAlarmas[1]]=item2
        itemAlarmas[grupoAlarmas[2]]=item3


    }

}