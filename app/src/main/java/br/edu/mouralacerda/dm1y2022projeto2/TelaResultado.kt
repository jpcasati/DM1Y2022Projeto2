package br.edu.mouralacerda.dm1y2022projeto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TelaResultado : AppCompatActivity() {

    var txtNome: TextView? = null
    var txtEmail: TextView? = null
    var txtFone: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultado)

        instanciarViews()

        txtNome!!.text = intent.getStringExtra("nome")
        txtEmail!!.text = intent.getStringExtra("email")
        txtFone!!.text = intent.getStringExtra("fone")
    }

    private fun instanciarViews() {
        txtNome = findViewById<TextView>(R.id.txtNome)
        txtEmail = findViewById<TextView>(R.id.txtEmail)
        txtFone = findViewById<TextView>(R.id.txtFone)
    }
}