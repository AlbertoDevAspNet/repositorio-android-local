package Algortimos

class Operacoes {
    fun somar(a: Int, b: Int): Int {
        return a + b
    }

    fun subtracao(a: Int, b: Int): Int {
       return a - b
    }
    fun multiplicacao(a: Int, b: Int): Int {
        println("Resultado: ${a*b}")
        return  a*b
    }

    fun division(a: Int, b: Int): Int {
       return  a/b
    }

    fun verificarPar(a: Int): Int{

        if(a % 2 ==0){
            println("Numero Par")
        }
        else{
            println("Numero Impar: ${a}")
        }

        return a
    }



}