package br.edu.mouralacerda.dm1y2022projeto2.model

import java.io.Serializable

data class Aluno(
    val nome: String,
    val email: String,
    val telefone: String,
    var curso: String?,
    var periodo: String?
): Serializable {}