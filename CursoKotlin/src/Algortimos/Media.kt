package Algortimos

class Media {
    fun resultado(){

        System.out.println("Digite primeira nota:")
        val av1 = readln().toDouble()
        System.out.println("Digite segunda nota:")
        val av2 = readln().toDouble()
        //System.out.println("Media igual a : ${av1+av2}:")

        val media = (av1+av2)/2

        if (media <5){
            System.out.println("Reprovado media igual a : $media")
        }
        else{
            System.out.println("Aprovado  media igual a : $media")
        }
    }
}