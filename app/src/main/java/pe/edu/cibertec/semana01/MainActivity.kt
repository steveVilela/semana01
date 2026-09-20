package pe.edu.cibertec.semana01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etAltura = findViewById<EditText>(R.id.etAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val strPeso = etPeso.text.toString()
            val strAltura = etAltura.text.toString()

            if (strPeso.isNotEmpty() && strAltura.isNotEmpty()) {
                val peso = strPeso.toFloat()
                val altura = strAltura.toFloat()

                if (altura > 0) {
                    val imc = peso / (altura * altura)

                    val diagnostico = when {
                        imc < 18.5 -> "Bajo peso"
                        imc in 18.5..24.9 -> "Peso normal"
                        imc in 25.0..29.9 -> "Sobrepeso"
                        else -> "Obesidad"
                    }

                    tvResultado.text = "IMC: %.2f\nClasificación: %s".format(imc, diagnostico)
                } else {
                    Toast.makeText(this, "La altura debe ser mayor a 0", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor complete ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}