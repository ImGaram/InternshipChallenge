package com.challenge.internshipchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
                InternshipNavHost(
                    navController = navController,
                    startDestination = MainRoute.Main.name
                )
            }
        }
    }
}