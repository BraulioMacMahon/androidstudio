package com.example.initialscreen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.initialscreen.PubCard
import com.example.initialscreen.ui.theme.InitialScreenTheme
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    criarPost: () -> Unit,
    terminarSessao: () -> Unit,
    viewmodel: HomeViewModel = HomeViewModel()
) {
    val firebase = FirebaseAuth.getInstance()
    val pubs = viewmodel.pubs.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Home Page",
                        fontSize = 20.sp,
                        color = Color.DarkGray
                    )
                },
                actions = {
                    IconButton(onClick = {
                        firebase.signOut()
                        terminarSessao()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ExitToApp,
                            contentDescription = null,
                            tint = Color.DarkGray
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFFDFE9F5)),
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { criarPost() },
                modifier = Modifier.clip(RoundedCornerShape(50.dp)),
                containerColor = Color.DarkGray
            ) {
                Text(
                    text = "+",
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray,
                    fontSize = 30.sp
                )
            }
        }
    ) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(pubs) { pub ->
                    PubCard(
                        pub = pub
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HamePagePreview() {
    InitialScreenTheme {
        HomePage(
            terminarSessao = {},
            criarPost = {}
        )
    }
}