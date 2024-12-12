package com.example.initialscreen.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.initialscreen.R
import com.example.initialscreen.ui.theme.GreetingTextEntrar
import com.example.initialscreen.ui.theme.TextFieldEmail
import com.example.initialscreen.ui.theme.TextFieldPassword
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LoginScreen(
    login: () -> Unit,
    criarConta: () -> Unit
) {
    val firebase = FirebaseAuth.getInstance()
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Scaffold(containerColor = MaterialTheme.colorScheme.background) { paddingValues ->
        Surface(
            modifier = Modifier.padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFFFF)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 70.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(R.drawable.logo),
                            contentDescription = null,
                            Modifier
                                .blur(0.dp)
                                .size(100.dp)
                                .alpha(3000f)
                        )
                        Text(
                            text = "ATOMIC",
                            fontFamily = FontFamily.Monospace,
                            color = Color.DarkGray
                        )
                    }

                    Spacer(modifier = Modifier.size(70.dp))

                    Card(
                        modifier = Modifier
                            .size(350.dp, 400.dp)
                            .clip(RoundedCornerShape(10)),
                        colors = CardDefaults.cardColors(Color(0xFFDFE9F5)),
                        elevation = CardDefaults.cardElevation(10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(25.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            GreetingTextEntrar(
                                title = stringResource(R.string.login)
                            )
                            Spacer(modifier = Modifier.size(30.dp))

                            var email by remember { mutableStateOf("") }
                            var password by remember { mutableStateOf("") }

                            TextFieldEmail(
                                value = email,
                                onValueChange = { email = it }
                            )

                            Spacer(modifier = Modifier.size(10.dp))

                            TextFieldPassword(
                                value = senha,
                                onValueChange = {
                                    firebase.signInWithEmailAndPassword(email, senha)
                                        .addOnCompleteListener { task ->
                                            if (task.isSuccessful) {
                                                login()
                                            } else {
                                                Toast.makeText(
                                                    context,
                                                    "Email ou senha incorreto",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                }
                            )

                            Spacer(modifier = Modifier.size(30.dp))

                            var cantoBtn = Shapes(small = RoundedCornerShape(15.dp))

                            Button(
                                onClick = { login() },
                                modifier = Modifier
                                    .size(150.dp, 50.dp)
                                    .clip(RoundedCornerShape(1f)),
                                colors = ButtonDefaults.buttonColors(Color(0xFF214CCE)),
                                shape = cantoBtn.small
                            ) {
                                Text(
                                    stringResource(R.string.login),
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFffffff),

                                    )
                            }
                            Row {
                                TextButton(
                                    onClick = { criarConta() },

                                    ) {
                                    Text(
                                        stringResource(R.string.create_acount),
                                        color = Color(0xFF214CCE)
                                    )
                                }
                            }

                        }
                    }

                }
            }

        }
    }

}


@Preview(
    showBackground = true,

    )
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        login = {},
        criarConta = {}
    )
}