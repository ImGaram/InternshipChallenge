package com.challenge.internshipchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.challenge.internshipchallenge.navigation.InternshipNavHost
import com.challenge.internshipchallenge.route.MainRoute
import com.challenge.internshipchallenge.ui.theme.InternshipChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            InternshipChallengeTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                        .imePadding()
                ) {
                    InternshipNavHost(
                        navController = navController,
                        startDestination = MainRoute.Main.name
                    )
                }
            }
        }
    }
}