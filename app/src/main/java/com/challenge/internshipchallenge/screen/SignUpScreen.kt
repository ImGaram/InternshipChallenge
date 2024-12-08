package com.challenge.internshipchallenge.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.challenge.internshipchallenge.navigation.SignUpNavHost
import com.challenge.internshipchallenge.route.SignUpRoute

@Composable
fun SignUpScreen(navigateToSignIn: () -> Unit = {}) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "back to sign in",
                    modifier = Modifier
                        .clickable { navigateToSignIn() }
                        .padding(vertical = 20.dp, horizontal = 16.dp)
                )

                Text(
                    text = "회원가입",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    ) { paddingValues ->
        SignUpNavHost(
            navController = navController,
            startDestination = SignUpRoute.Name.name,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen()
}