package com.example.notas.data

import androidx.lifecycle.MutableLiveData

class DataBase {

    private val mDataBase: MutableLiveData<MutableList<Nota>> = MutableLiveData()

    fun inserirNota(nota: Nota) {
        var tmp = mDataBase.value
        if (tmp == null) {
            tmp = mutableListOf(nota)
        } else {
            tmp.add(nota)
        }
        mDataBase.postValue(tmp)
    }

    fun obterNotas() = mDataBase
}