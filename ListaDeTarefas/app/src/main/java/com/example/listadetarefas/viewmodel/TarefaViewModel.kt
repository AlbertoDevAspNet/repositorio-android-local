package com.example.listadetarefas.viewmodel

import androidx.lifecycle.ViewModel
import com.example.listadetarefas.modelo.Tarefa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TarefaViewModel: ViewModel() {

    private val _tarefas = MutableStateFlow<List<Tarefa>>(emptyList())
    val tarefas: StateFlow<List<Tarefa>> = _tarefas

    fun adicionarTarefa(titulo: String, descricao: String = "") {
        if (titulo.isBlank()) return
        val novaTarefa = Tarefa(titulo = titulo.trim(), descricao = descricao.trim())
        _tarefas.update { listaAtual -> listaAtual + novaTarefa }
    }

    fun alternarConclusao(tarefaId: String) {
        _tarefas.update { listaAtual ->
            listaAtual.map { tarefa ->
                if (tarefa.id == tarefaId) {
                    tarefa.copy(concluida = !tarefa.concluida)
                } else {
                    tarefa
                }
            }
        }
    }

    fun removerTarefa(tarefaId: String) {
        _tarefas.update { listaAtual ->
            listaAtual.filter { it.id != tarefaId }
        }
    }

    val totalTarefas: Int
        get() = _tarefas.value.size

    val tarefasConcluidas: Int
        get() = _tarefas.value.count { it.concluida }

}