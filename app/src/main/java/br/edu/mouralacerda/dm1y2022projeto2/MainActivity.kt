package br.edu.mouralacerda.dm1y2022projeto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var edtNome: EditText? = null
    var edtEmail: EditText?  = null
    var edtFone: EditText? = null

    var btnEnviar: ImageButton? = null
    var btnLimpar: ImageButton? = null
    var btnFechar: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instanciarViews()

        btnLimpar!!.setOnClickListener { limparCampos() }
        btnFechar!!.setOnClickListener { finish() }

        btnEnviar!!.setOnClickListener {

            if(verificarCampoVazio()) {
                val intencao = Intent(this, TelaResultado::class.java)

                intencao.putExtra("nome", edtNome!!.text.toString())
                intencao.putExtra("email", edtEmail!!.text.toString())
                intencao.putExtra("fone", edtFone!!.text.toString())

                startActivity(intencao)
            } else {
                Toast.makeText(
                    this, "Preencha os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()

        limparCampos()
    }

    private fun limparCampos() {
        edtNome!!.text.clear()
        edtEmail!!.text.clear()
        edtFone!!.text.clear()

        edtNome!!.requestFocus()
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Não vai fechar!", Toast.LENGTH_LONG).show()
    }

    fun instanciarViews() {
        edtNome = findViewById<EditText>(R.id.edtNome)
        edtEmail = findViewById<EditText>(R.id.edtEmail)
        edtFone = findViewById<EditText>(R.id.edtFone)
        btnEnviar = findViewById<ImageButton>(R.id.btnEnviar)
        btnLimpar = findViewById<ImageButton>(R.id.btnLimpar)
        btnFechar = findViewById<ImageButton>(R.id.btnFechar)
    }

    fun verificarCampoVazio(): Boolean {

        if(edtNome!!.text.toString().isEmpty())
            return false
        if(edtEmail!!.text.toString().isEmpty())
            return false
        if(edtFone!!.text.toString().isEmpty())
            return false

        return true
    }

}


