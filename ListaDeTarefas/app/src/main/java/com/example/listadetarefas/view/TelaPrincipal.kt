package com.example.listadetarefas.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.listadetarefas.modelo.Tarefa
import com.example.listadetarefas.viewmodel.TarefaViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.*

import java.lang.reflect.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun TelaPrincipal(viewModel: TarefaViewModel) {
    val tarefas by viewModel.tarefas.collectAsState()
    var novoTitulo by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Tarefas") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = androidx.compose.ui.Modifier.fillMaxSize().padding(paddingValues).padding(16.dp)
                //.fillMaxSize()
               // .padding(paddingValues)
               // .padding(16.dp)
        ) {
            Row(
                modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = novoTitulo,
                    onValueChange = { novoTitulo = it },
                    label = { Text("Nova tarefa") },
                    modifier = androidx.compose.ui.Modifier.weight(1f),
                    singleLine = true
                )
                Spacer(modifier = androidx.compose.ui.Modifier.width(8.dp))
                    // Modifier.width(8.dp))
                IconButton(
                    onClick = {
                        viewModel.adicionarTarefa(novoTitulo)
                        novoTitulo = ""
                    }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Adicionar")
            }

            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

            Text(
                text = "Total: ${tarefas.size} | Concluídas: ${tarefas.count { it.concluida }}",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))

            LazyColumn {
                items(tarefas, key = { it.id }) { tarefa ->
                    CartaoTarefa(
                        tarefa = tarefa,
                        onAlternar = { viewModel.alternarConclusao(tarefa.id) },
                        onRemover = { viewModel.removerTarefa(tarefa.id) }
                    )
                }
            }
        }
    }
}

@Composable
fun CartaoTarefa(
    tarefa: Tarefa,
    onAlternar: () -> Unit,
    onRemover: () -> Unit
) {
    Card(
        modifier = androidx.compose.ui.Modifier.fillMaxWidth()
            .padding(vertical = 16.dp)

    ) {
        Row(
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = tarefa.concluida,
                onCheckedChange = { onAlternar() }
            )
            Text(
                text = tarefa.titulo,
                modifier = androidx.compose.ui.Modifier.weight(1f),
                textDecoration = if (tarefa.concluida) {
                    TextDecoration.LineThrough
                } else {
                    TextDecoration.None
                }
            )
            IconButton(onClick = onRemover) {
                Icon(Icons.Default.Delete, contentDescription = "Remover")
            }
        }
    }
}

