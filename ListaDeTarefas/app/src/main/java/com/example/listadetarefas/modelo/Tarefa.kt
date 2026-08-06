package com.example.listadetarefas.modelo

import java.util.UUID

data class Tarefa(

    val id: String = UUID.randomUUID().toString(),
    val titulo: String,
    val descricao: String = "",
    val concluida: Boolean = false
)
