package br.edu.mouralacerda.dm1y2022projeto2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.edu.mouralacerda.dm1y2022projeto2.databinding.ActivityMainBinding
import br.edu.mouralacerda.dm1y2022projeto2.model.Aluno

class MainActivity : AppCompatActivity() {

    private val b by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.btnLimpar.setOnClickListener { limparCampos() }
        b.btnFechar.setOnClickListener { finish() }

        b.btnEnviar.setOnClickListener {

            if(verificarCampoVazio()) {
                val intencao = Intent(this, TelaDados2::class.java)

                val a = Aluno(
                    b.edtNome.text.toString(),
                    b.edtEmail.text.toString(),
                    b.edtFone.text.toString(),
                    null,
                    null
                )

                intencao.putExtra("aluno", a)

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
        b.edtNome.text.clear()
        b.edtEmail.text.clear()
        b.edtFone.text.clear()

        b.edtNome.requestFocus()
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Não vai fechar!", Toast.LENGTH_LONG).show()
    }

    fun verificarCampoVazio(): Boolean {

        if(b.edtNome.text.toString().isEmpty())
            return false
        if(b.edtEmail.text.toString().isEmpty())
            return false
        if(b.edtFone.text.toString().isEmpty())
            return false

        return true
    }

}


