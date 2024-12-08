package com.challenge.internshipchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.challenge.internshipchallenge.route.MainRoute
import com.challenge.internshipchallenge.route.SignUpRoute
import com.challenge.internshipchallenge.screen.MainScreen
import com.challenge.internshipchallenge.screen.ProfileScreen
import com.challenge.internshipchallenge.screen.SignInScreen
import com.challenge.internshipchallenge.screen.signup.SignUpImageScreen
import com.challenge.internshipchallenge.screen.signup.SignUpNameScreen
import com.challenge.internshipchallenge.screen.signup.SignUpPasswordScreen

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
                navigateToSignUpName = { navController.navigate(SignUpRoute.Name.name) }
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

        composable(SignUpRoute.Name.name) {
            SignUpNameScreen(
                navigateToImage = { navController.navigate(SignUpRoute.Image.name) },
                navigateToMain = { navController.popBackStack() }
            )
        }

        composable(SignUpRoute.Image.name) {
            SignUpImageScreen(
                navigateToName = { navController.popBackStack() },
                navigateToPassword = { navController.navigate(SignUpRoute.Password.name) }
            )
        }

        composable(SignUpRoute.Password.name) {
            SignUpPasswordScreen(
                navigateToImage = { navController.popBackStack() },
                navigateToSignIn = { navController.navigate(MainRoute.SignIn.name) }
            )
        }
    }
}