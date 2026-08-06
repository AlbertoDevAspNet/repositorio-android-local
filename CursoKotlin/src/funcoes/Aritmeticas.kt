package funcoes

fun main(){

    val x = 8
    val y = 9

   println("soma igual: ${x + y}")
    System.out.println("Digite um numero:")
    val z = readln().toInt()

    System.out.println("Operadores Aritmeticos em Kotlin:")
    System.out.println("Digite um numero:")
    val a = readln().toInt()
    System.out.println("Digite outro Numero :")
    val b = readln().toInt()
    System.out.println("Soma igual a :${a+b}")
    System.out.println("A diferenca vale : ${a-b}")
    System.out.println("A multiplicacao sera: ${a*b}")
    System.out.println("A Divisao sera: ${a/b}")
    System.out.println("Digite outro numero:")
    val c= readln().toInt()
    System.out.println("Resto da divisao igual a : ${a%c}")

}

