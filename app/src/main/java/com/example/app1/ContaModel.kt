package com.example.app1

import java.util.*

class ContaModel : Observable(){

    var valorTotalConta: Double
    var qtdePessoas: Int
    var valorDividido: Double

    init {
        // reserving the space for list elements
        valorTotalConta = 0.0
        qtdePessoas = 0
        valorDividido = 0.0
    }

    fun getValueValorTotalConta(): Double {
        return valorTotalConta
    }

    fun getValueQtdePessoas(): Int {
        return qtdePessoas
    }

    fun getValueValorDividido(): Double {
        return valorDividido
    }

    fun setValueValorTotalConta(total: Double) {
        valorTotalConta = total
    }

    fun setValueQtdePessoas(pessoas: Int) {
        qtdePessoas = pessoas
    }

    fun setValueValorDividido(dividido: Double) {
        valorDividido = dividido
    }

}