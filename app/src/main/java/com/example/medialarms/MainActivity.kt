package com.example.medialarms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ExpandableListView
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.medialarms.ui.theme.MediAlarmsTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val btnAlarmas: Button =findViewById(R.id.button_mis_alarmas)

        val btnMedicamentos: Button =findViewById(R.id.button_mis_medicamentos)

        btnAlarmas.setOnClickListener {
            val intent : Intent = Intent(this, AlarmasActivity::class.java)
            startActivity(intent)
        }


        btnMedicamentos.setOnClickListener {
            val intentM : Intent = Intent(this, MedicamentosActivity::class.java)
            startActivity(intentM)
        }


    }




}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MediAlarmsTheme {
        Greeting("Android")
    }
}
