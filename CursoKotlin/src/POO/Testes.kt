package POO

import Algortimos.Media
import Algortimos.Operacoes
import Algortimos.Vetores

fun main(){

    var teste =  Media()
    //teste.resultado()
    var oper= Operacoes()
    //oper.multiplicacao(8,7)
   // oper.verificarPar(7)
    var vetor= Vetores()
    //vetor.exibirMensagem()

    var testar= Testar()
    testar.verificarDiaDaSemana()


    }

class Testar {

    fun verificarDiaDaSemana() {
        println("Dia Dia Dia Semana : Digite um numero entre 0 e 6")
        val numero = readln().toInt()
        when (numero) {
            0 -> println("Domingo")
            1 -> println("Segunda")
            2 -> println("Terca")
            3 -> println("Quarta")
            4 -> println("Quinta")
            5 -> println("Sexta")
            6 -> println("Sabado")
            else -> println("Entrada Incorreta: ")
        }
    }



}