package com.example.initialscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.initialscreen.create_account.CreateUserAcount
import com.example.initialscreen.createpubpage.CreatePubPage
import com.example.initialscreen.home.HomePage
import com.example.initialscreen.login.LoginScreen
import com.example.initialscreen.ui.theme.InitialScreenTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InitialScreenTheme {

                installSplashScreen()
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = RotaHome){
                    composable<RotaLogin> {
                        LoginScreen(
                            login = { navController.navigate(RotaHome) },
                            criarConta = { navController.navigate(RotaCriarConta) }
                        )
                    }
                    composable<RotaCriarConta> {
                        CreateUserAcount(
                            login = { navController.navigate(RotaLogin) }
                        )
                    }
                    composable<RotaHome> {
                        HomePage(
                            criarPost = { navController.navigate(RotaCriarPub) },
                            terminarSessao = { navController.navigate(RotaLogin) }
                        )
                    }
                    composable<RotaCriarPub> {
                        CreatePubPage()
                    }
                }
            }
        }
    }

}

