package br.edu.mouralacerda.dm1y2022projeto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnviar = findViewById<ImageButton>(R.id.btnEnviar)

        btnEnviar.setOnClickListener {

            val intencao = Intent(this, TelaResultado::class.java)

            val parametros = Bundle()

            val edtNome = findViewById<EditText>(R.id.edtNome)
            val edtEmail = findViewById<EditText>(R.id.edtEmail)
            val edtFone = findViewById<EditText>(R.id.edtFone)

            val nomeDigitado = edtNome.text.toString()
            val emailDigitado = edtEmail.text.toString()
            val foneDigitado = edtFone.text.toString()

            parametros.putString("nome", nomeDigitado)
            parametros.putString("email", emailDigitado)
            parametros.putString("fone", foneDigitado)

            intencao.putExtras(parametros)

            startActivity(intencao)

        }

    }
}