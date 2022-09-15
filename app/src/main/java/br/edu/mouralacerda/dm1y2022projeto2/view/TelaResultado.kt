package br.edu.mouralacerda.dm1y2022projeto2.view

import br.edu.mouralacerda.dm1y2022projeto2.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.edu.mouralacerda.dm1y2022projeto2.model.Aluno

class TelaResultado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultado)

        val a = intent.getSerializableExtra("aluno") as Aluno

        findViewById<TextView>(R.id.txtNome).text = a.nome
        findViewById<TextView>(R.id.txtEmail).text = a.email
        findViewById<TextView>(R.id.txtFone).text = a.telefone
        findViewById<TextView>(R.id.txtCurso).text = a.curso
        findViewById<TextView>(R.id.txtPeriodo).text = a.periodo

    }

}