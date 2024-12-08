package com.challenge.internshipchallenge.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.challenge.internshipchallenge.R

@Composable
fun MainScreen(
    navigateToSignUp: () -> Unit = {},
    navigateToProfile: () -> Unit = {}
) {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            imageVector = Icons.Default.AccountBox,
            contentDescription = "app icon",
            modifier = Modifier.size(50.dp)
        )

        Text(
            text = "한 달 인턴 지원자 관리 서비스",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        Text(
            text = "서비스에 로그인하세요",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 16.sp
            )
        )

        Image(
            painter = painterResource(R.drawable.icon_doc_list),
            contentDescription = "main image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(vertical = 40.dp)
                .width((width - width / 3).dp)
                .rotate(25f)
                .align(Alignment.CenterHorizontally)
        )

        Button(
            onClick = { navigateToProfile() },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006A67))
        ) {
            Text(text = "로그인하기")
        }

        Text(
            text = "회원가입",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { navigateToSignUp() }
                .padding(vertical = 4.dp),
            style = TextStyle(
                color = Color.Blue,
            ),
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}