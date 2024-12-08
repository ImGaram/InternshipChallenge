package com.challenge.internshipchallenge.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.challenge.internshipchallenge.data.UserData
import com.challenge.internshipchallenge.route.MainRoute
import com.challenge.internshipchallenge.screen.MainScreen
import com.challenge.internshipchallenge.screen.ProfileScreen
import com.challenge.internshipchallenge.screen.SignInScreen
import com.challenge.internshipchallenge.screen.SignUpScreen
import com.google.gson.Gson

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
                navigateToProfile = {
                    val json = Uri.encode(Gson().toJson(it))
                    navController.navigate("${MainRoute.Profile.name}/$json")
                },
                navigateToMain = { navController.navigate(MainRoute.Main.name) }
            )
        }

        composable(
            route = "${MainRoute.Profile.name}/{UserData}",
            arguments = listOf(navArgument("UserData") { type = NavType.StringType })
        ) { navBackStackEntry ->
            val json = navBackStackEntry.arguments?.getString("UserData")
            val userData = Gson().fromJson(json, UserData::class.java)

            ProfileScreen(
                userData = userData,
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