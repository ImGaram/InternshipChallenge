package com.challenge.internshipchallenge.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.challenge.internshipchallenge.R
import com.challenge.internshipchallenge.data.UserData

@Composable
fun ProfileScreen(
    userData: UserData = UserData(),
    navigateToSignIn: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "로그인한 사용자",
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }

        Image(
            painter = painterResource(R.drawable.icon_doc_list),
            contentDescription = "login title image",
            modifier = Modifier
                .padding(vertical = 24.dp)
                .size(150.dp)
        )

        Text(
            text = "사용자 ID: ${userData.id}",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        )

        Text(
            text = "사용자 이름: ${userData.name}",
            modifier = Modifier.padding(top = 4.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        )

        Text(
            text = "사용자 비밀번호: ${userData.password}",
            modifier = Modifier.padding(top = 4.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        )
        
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = navigateToSignIn,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 36.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006A67))
        ) {
            Text(text = "로그아웃")
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}