package com.example.testeimc.dataresource

import android.annotation.SuppressLint

object Calculator {

    @SuppressLint("DefaultLocale")
    fun calcularIMC(height: String, weight: String, response: (String, Boolean) -> Unit) {

        if ( height.isNotEmpty() && weight.isNotEmpty() ) {
            // senao estiver vazio realizar calculo de IMC
            val pesoFormatado = weight.replace(",", ".").toDoubleOrNull()
            val alturaFormatada = height.toDoubleOrNull()

            if (pesoFormatado != null && alturaFormatada != null) {
                //peso/(altura²)
                val imc= pesoFormatado/(alturaFormatada/100 * alturaFormatada/100)
                val imcFormatado = String.format("%.2f", imc)
                when{
                imc < 18.5 -> response("IMC: $imcFormatado \n Abaixo do Peso", false)
                imc in 18.5 ..24.9 -> response("IMC: $imcFormatado \n Peso Normal:", false)
                imc in 24.5 .. 29.9 -> response("IMC: $imcFormatado \n Sobrepeso:", false)
                imc in 30.0 .. 34.9 -> response("IMC: $imcFormatado \n Obesidade (Grau 1):", false)
                imc in 35.0 .. 39.9 -> response("IMC: $imcFormatado \n Obesidade Severa (Grau 2):", false)
               else -> response("IMC: $imcFormatado \n Obesidade Mórbida (Grau 3):", false)
                }
            }


        } else{
            response("Preencha todos os campos",true)
        }
    }
}