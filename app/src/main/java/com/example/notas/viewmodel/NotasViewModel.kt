package com.example.notas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notas.data.DataBase
import com.example.notas.data.GestorDeNotas
import com.example.notas.data.Nota

class NotasViewModel(val gestorDeNotas: GestorDeNotas) : ViewModel() {

    private var mNotas: MutableLiveData<MutableList<Nota>> = MutableLiveData()

    fun getNotas(): LiveData<MutableList<Nota>> {
        mNotas = gestorDeNotas.getNotas()
        return mNotas
    }

    fun addNota(mNota: Nota) {
        gestorDeNotas.addNotas(mNota)
    }

}