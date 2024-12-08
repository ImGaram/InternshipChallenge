package com.challenge.internshipchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.challenge.internshipchallenge.route.MainRoute
import com.challenge.internshipchallenge.route.SignUpRoute
import com.challenge.internshipchallenge.screen.signup.SignUpImageScreen
import com.challenge.internshipchallenge.screen.signup.SignUpNameScreen
import com.challenge.internshipchallenge.screen.signup.SignUpPasswordScreen

@Composable
fun SignUpNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(SignUpRoute.Name.name) {
            SignUpNameScreen(
                navigateToImage = { navController.navigate(SignUpRoute.Image.name) }
            )
        }

        composable(SignUpRoute.Image.name) {
            SignUpImageScreen(
                navigateToName = { navController.navigate(SignUpRoute.Name.name) },
                navigateToPassword = { navController.navigate(SignUpRoute.Password.name) }
            )
        }

        composable(SignUpRoute.Password.name) {
            SignUpPasswordScreen(
                navigateToImage = { navController.navigate(SignUpRoute.Image.name) },
                navigateToSignIn = { navController.navigate(MainRoute.SignIn.name) }
            )
        }
    }
}