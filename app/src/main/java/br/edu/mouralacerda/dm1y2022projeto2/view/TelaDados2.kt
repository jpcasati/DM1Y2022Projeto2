package br.edu.mouralacerda.dm1y2022projeto2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.edu.mouralacerda.dm1y2022projeto2.R
import br.edu.mouralacerda.dm1y2022projeto2.model.Aluno

class TelaDados2 : AppCompatActivity() {

    var menuCursos: Spinner? = null
    var periodo: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_dados2)

        instanciar()

        val listaCursos = resources.getStringArray(R.array.cursos)

        var adp = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            listaCursos
        )
        menuCursos!!.adapter = adp

        val a = intent.getSerializableExtra("aluno") as Aluno

        findViewById<ImageButton>(R.id.btnVoltar).setOnClickListener {
            finish()
        }

        val botao = findViewById<ImageButton>(R.id.btnEnviar2)
        botao.setOnClickListener {

            if(verificarCampoVazio()) {

                a.curso = menuCursos!!.selectedItem.toString()
                a.periodo = periodo!!.text.toString()

                val i = Intent(this, TelaResultado::class.java)

                i.putExtra("aluno", a)

                startActivity(i)
            } else {
                Toast.makeText(
                    this, "Preencha os campos", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun verificarCampoVazio(): Boolean {

        if(periodo!!.text.toString().isEmpty())
            return false
        if(menuCursos!!.selectedItem.toString() == "Selecione um curso")
            return false

        return true
    }

    fun instanciar() {
        menuCursos = findViewById<Spinner>(R.id.spnCurso)
        periodo = findViewById<EditText>(R.id.edtPeriodo)
    }
}