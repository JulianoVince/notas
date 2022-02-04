package com.example.notas.data

class GestorDeNotas(val dataBase: DataBase) {

    fun getNotas() = dataBase.obterNotas()

    fun addNotas(mNota: Nota) {
        dataBase.inserirNota(mNota)
    }

}