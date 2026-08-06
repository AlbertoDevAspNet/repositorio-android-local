package Algortimos

class ExercicioAula{

    fun verificaIdade(){
        System.out.println("Digite a idade :")
        val idade = readln().toInt()

        if(idade ==0 || idade <13){
            System.out.println("Filmes Infantis: ")
        }
        else if(idade >12 && idade <19)
        {
            System.out.println("Filmes Adolescentes :")
        }

        else  if(idade >18){

            System.out.println("Filmes Adultos :")
        }
        else {
            System.out.println("Entrada incorreta :")
        }
    }
}