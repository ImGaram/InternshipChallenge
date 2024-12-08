package com.challenge.internshipchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.challenge.internshipchallenge.route.MainRoute
import com.challenge.internshipchallenge.screen.MainScreen
import com.challenge.internshipchallenge.screen.ProfileScreen
import com.challenge.internshipchallenge.screen.SignInScreen
import com.challenge.internshipchallenge.screen.SignUpScreen

@Composable
fun InternshipNavHost(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainRoute.Main.name) {
            MainScreen(
                navigateToSignIn = { navController.navigate(MainRoute.SignIn.name) },
                navigateToSignUp = { navController.navigate(MainRoute.SignUp.name) }
            )
        }

        composable(MainRoute.SignIn.name) {
            SignInScreen(
                navigateToProfile = { navController.navigate(MainRoute.Profile.name) },
                navigateToMain = { navController.navigate(MainRoute.Main.name) }
            )
        }

        composable(MainRoute.Profile.name) {
            ProfileScreen(
                navigateToSignIn = { navController.navigate(MainRoute.SignIn.name) }
            )
        }

        composable(MainRoute.SignUp.name) {
            SignUpScreen(
                navigateToSignIn = { navController.navigate(MainRoute.SignIn.name) },
                navigateToMain = { navController.popBackStack() }
            )
        }
    }
}