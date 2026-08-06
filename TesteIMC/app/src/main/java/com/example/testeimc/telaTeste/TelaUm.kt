package com.example.testeimc.telaTeste

import android.R.attr.label
import android.R.attr.text
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testeimc.dataresource.Calculator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaUmDemo() {
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var textfieldError by remember { mutableStateOf(false) }
    var resultadoMensagem by remember { mutableStateOf("") }


    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Calculadora IMC")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )



        }

    )
    {paddingValues ->

        Column (
            modifier = Modifier.padding(paddingValues)
                .background(
                    color = Color.White
                ).verticalScroll(rememberScrollState())
        )
        {
            Row(
                modifier= Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Altura (cm)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp, 100.dp, 0.dp, 0.dp)
                )
                /*testando */

                Text(
                    text = "Peso (Kg)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp, 100.dp, 20.dp, 0.dp)
                )
            }
            /*a testar ainda */
            Row (
                modifier= Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            )
            {


                OutlinedTextField(
                    value = height,
                    onValueChange = {
                        if (it.length <= 3){
                            height = it
                        }
                    },

                    label = {
                        Text(text = "165")
                    },
                    modifier = Modifier.fillMaxWidth(0.4f).padding(20.dp, 0.dp, 0.dp, 20.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword
                    )
                    ,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = White,
                        focusedContainerColor = White,
                        errorContainerColor = White,
                        focusedLabelColor = Blue,
                        focusedIndicatorColor = Blue,
                        cursorColor = Blue),
                    isError = textfieldError
                )


                /*
                *  Mais Um OutlinedTextFiedl
                *
                *  */


                OutlinedTextField(
                    value = weight,
                    onValueChange = {
                        if (it.length <= 7){
                            weight = it
                        }
                    },

                    label = {
                        Text(text = "70.50")
                    },
                    modifier = Modifier.fillMaxWidth(0.5f).padding(20.dp, 0.dp, 20.dp, 20.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    )
                    ,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = White,
                        focusedContainerColor = White,
                        errorContainerColor = White,
                        focusedLabelColor = Blue,
                        focusedIndicatorColor = Blue,
                        cursorColor = Blue),
                    isError = textfieldError
                )

                /*
                *
                *
                *
                * */

            }
            /**/
            Button(
                onClick = {
                    Calculator.calcularIMC(height = height, weight = weight, response = { result, textFieldState ->

                        resultadoMensagem= result
                        textfieldError = textFieldState
                    })

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                ),
                modifier= Modifier.fillMaxWidth().height(150.dp).padding(50.dp)
            ){
                Text(
                    text="CALCULAR",
                    fontSize = 18.sp,
                    color = White,
                    fontWeight = FontWeight.Bold
                )

            }

            Text(
                text= resultadoMensagem,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Blue,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun TelaUmDemoPreview() {
    TelaUmDemo()
}
