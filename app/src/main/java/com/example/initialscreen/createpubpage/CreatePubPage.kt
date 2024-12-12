package com.example.initialscreen.createpubpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.initialscreen.ui.theme.TextFieldTextPub
import com.example.initialscreen.ui.theme.TextFieldUrl

@Composable
fun CreatePubPage(
    viewModel: CreatPubViewModel = CreatPubViewModel()
){
    var url by remember { mutableStateOf("") }
    var textPub by remember { mutableStateOf("") }

    Scaffold() { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .background(Color(0xFFDFE9F5),
                            RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.padding(40.dp))
                    TextFieldUrl(
                        value = url,
                        onValueChange = { url = it }
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    TextFieldTextPub(
                        value = textPub,
                        onValueChange = { textPub = it }
                    )
                    Spacer(modifier = Modifier.padding(20.dp))

                    Button(
                        onClick = {
                            viewModel.adicionarPub(url, textPub)
                            url = ""
                            textPub = ""
                        }
                    ) {
                        Text(
                            text = "Create Pub"
                        )
                    }
                }
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun CreatePubPagePreview(){
    CreatePubPage()
}