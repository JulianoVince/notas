package com.example.notas.ui.activitys

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notas.NotasAdapter
import com.example.notas.R
import com.example.notas.data.Nota
import com.example.notas.viewmodel.NotasViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_ui.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    //Inicializando viewModel com koin
    private val notasViewModel: NotasViewModel by viewModel()

    val notasAdapter: NotasAdapter by lazy {
        NotasAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        recyclerView.adapter = notasAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Inicializar ViewModel
//        notasViewModel = ViewModelProviders.of(this).get(NotasViewModel::class.java)

        //Escutar atualização do ViewModel
        notasViewModel.getNotas().observe(this, { observerListNotas ->
            notasAdapter.addAll(observerListNotas)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_adicionar) {
            addNota()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addNota() {
        val layoutDialog = LayoutInflater.from(this).inflate(R.layout.dialog_ui, null, false)

        val inputNota = layoutDialog.editTextAdd
        val nomeNota = inputNota.text

        val dialog = AlertDialog.Builder(this)
        dialog.setView(layoutDialog)
        dialog.setNegativeButton("Cancelar", null)
        dialog.setPositiveButton("Salvar") { d, i ->

            var nota = Nota(0,nomeNota.toString())
            notasViewModel.addNota(nota)
        }
        dialog.create().show()
    }
}