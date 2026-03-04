package com.example.componentesestado

import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.oswald_bold
import com.example.componentesestado.ui.theme.oswald_regular
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //BasicComponentScreen(modifier = Modifier.padding(innerPadding))
                    //TestComponentScreen(modifier = Modifier.padding(innerPadding))
                    TestEstadosScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BasicComponentScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.Gray)
            .fillMaxSize()
    ) {
        Text(
            text = "Aulas Android",
            modifier = modifier.fillMaxWidth(),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Color(233, 211, 255),
            textAlign = TextAlign.End
        )
        Text(
            text = "com jetpack compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = oswald_bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        TextField(
            value = "",
            onValueChange = {}
        )
    }
}

@Composable
fun TestComponentScreen(modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        AndroidEmeny(modifier = Modifier.size(70.dp), color = Color.Red)
    }
}

@Composable
fun TestEstadosScreen(modifier: Modifier = Modifier){
    var backgroundColor by remember {
        mutableStateOf(Color.Gray)
    }

    Column(
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var valorCampo by remember {
            mutableStateOf("Android")
        }

        TextField(
            value = valorCampo,
            onValueChange = { novoValor ->
                Log.i("teste", novoValor)

                valorCampo = novoValor
            },

            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        var valorCampo2 by remember {
            mutableStateOf("")
        }

        TextField(
            value = valorCampo2,
            onValueChange = { novoValor ->
                Log.i("teste", novoValor)

                valorCampo2 = novoValor
            },

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = {
                Text(
                    text = "Digite o seu nome"
                )
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person Icon",
                    tint = Color.Yellow
                )
            },

            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Blue,
                unfocusedTextColor = Color.Black,
                unfocusedPlaceholderColor = Color.Green
            ),

            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        var email by remember {
            mutableStateOf("")
        }

        OutlinedTextField (
            value = email,
            onValueChange = {
                email = it
            },
            singleLine = true,
            placeholder = {
                Text(
                    text = "Digite o seu email"
                )
            },

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.Blue,
                unfocusedPlaceholderColor = Color.White
            ),

            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp
            )

        )

        var jCompose by remember{
            mutableStateOf(false)
        }

        var xml by remember{
            mutableStateOf(false)
        }

        var ios by remember {
            mutableStateOf(false)
        }

        var android by remember {
            mutableStateOf(false)
        }

        var sOperacional by remember {
            mutableStateOf("")
        }



        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = jCompose,
                onCheckedChange = {
                    jCompose = it
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Yellow
                )
            )

            Text(
                text = "Jetpack Compose"
            )
        }



        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = xml,
                onCheckedChange = {
                    xml = it
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Yellow
                )
            )

            Text(
                text = "XML"
            )
        }



        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sOperacional == "ios",
                onClick = {
                    sOperacional = "ios"
                }
            )

            Text(
                text = "IOS"
            )
        }



        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sOperacional == "android",
                onClick = {
                    sOperacional = "android"
                }
            )

            Text(
                text = "ANDROID"
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sOperacional == "aPhone",
                onClick = {
                    sOperacional = "aPhone"
                }
            )

            Text(
                text = "WINDOWS PHONE"
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    backgroundColor = Color.Cyan
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.Black
                ),
                border = BorderStroke(width = 4.dp, color = Color.Yellow),
                shape = RoundedCornerShape(topEnd = 10.dp, bottomStart = 10.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Icon Star"
                )

                Text(
                    text = "Clique Aqui"
                )
            }

            OutlinedButton(
                onClick = {
                    backgroundColor = Color.Gray
                }
            ) {
                Text(text = "Outro butao")
            }

        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            var favoritado by remember {
                mutableStateOf(false)
            }

            if (favoritado){
                Icon(
                    modifier = Modifier.clickable{
                        favoritado = false
                    },

                    imageVector = Icons.Default.Favorite,
                    contentDescription = "favoritado"
                )
            }else{
                Icon(
                    modifier = Modifier.clickable{
                        favoritado = true
                    },
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "favorito"
                )
            }



        }




    }
}

@Composable
fun AndroidEmeny(modifier: Modifier = Modifier, color: Color){
    androidx.compose.foundation.Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Android Emeny",
        colorFilter = ColorFilter.tint(color)
    )
}