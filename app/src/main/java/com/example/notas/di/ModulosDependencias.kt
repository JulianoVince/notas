package com.example.notas.di

import com.example.notas.data.DataBase
import com.example.notas.data.GestorDeNotas
import com.example.notas.viewmodel.NotasViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ModulosDependencias {

    val moduloDaApp = module {

        single {
            DataBase()
        }

        factory {
            GestorDeNotas(get())
        }

        viewModel { NotasViewModel(get()) }
    }
}