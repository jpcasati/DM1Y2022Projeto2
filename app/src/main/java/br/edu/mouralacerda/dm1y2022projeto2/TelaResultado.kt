package br.edu.mouralacerda.dm1y2022projeto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TelaResultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultado)

        val parametros = intent.extras

        val nomeDigitado = parametros!!.getString("nome")
        val emailDigitado = parametros.getString("email")
        val foneDigitado = parametros.getString("fone")

        val txtNome = findViewById<TextView>(R.id.txtNome)
        val txtEmail = findViewById<TextView>(R.id.txtEmail)
        val txtFone = findViewById<TextView>(R.id.txtFone)

        txtNome.text = nomeDigitado
        txtEmail.text = emailDigitado
        txtFone.text = foneDigitado

    }
}