package com.challenge.internshipchallenge.screen.signup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpPasswordScreen(
    navigateToImage: () -> Unit = {},
    navigateToSignIn: () -> Unit = {}
) {
    val pw = remember { mutableStateOf("") }
    val pwCheck = remember { mutableStateOf("") }
    val pwError = remember { mutableStateOf(false) }
    val pwCheckError = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 36.dp, horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = "app icon",
            modifier = Modifier.size(50.dp)
        )

        Text(
            text = "한 달 인턴 지원",
            modifier = Modifier.padding(vertical = 8.dp),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        Text(
            text = "비밀번호를 입력하세요",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 20.sp
            )
        )

        TextField(
            value = pw.value,
            onValueChange = { pw.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp),
            label = { Text(text = "비밀번호") },
            placeholder = { Text(text = "비밀번호를 입력해주세요") },
            trailingIcon = {
                IconButton(onClick = { pw.value = "" }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "id clear text icon",
                    )
                }
            },
            isError = pwError.value,
            supportingText = {
                if (pwError.value) Text(text = "비어 있어요")
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0x1A0000FF),
                unfocusedIndicatorColor = Color.Blue,
                focusedIndicatorColor = Color.Blue
            )
        )

        TextField(
            value = pwCheck.value,
            onValueChange = { pwCheck.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            label = { Text(text = "비밀번호 확인") },
            placeholder = { Text(text = "비밀번호를 다시 입력해주세요") },
            trailingIcon = {
                IconButton(onClick = { pwCheck.value = "" }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "user name clear text icon",
                    )
                }
            },
            isError = pwCheckError.value,
            supportingText = {
                if (pwCheckError.value) Text(text = "비밀번호가 틀려요")
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0x1A0000FF),
                unfocusedIndicatorColor = Color.Blue,
                focusedIndicatorColor = Color.Blue
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                pwError.value = pw.value.isEmpty()
                pwCheckError.value = pwCheck.value != pw.value

                if (!pwError.value && !pwCheckError.value) {
                    // todo :: fireStore save 로직, storage save 로직
                    navigateToSignIn()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006A67))
        ) {
            Text(text = "완료")
        }

        OutlinedButton(
            onClick = navigateToImage,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(width = 1.dp, color = Color(0xFF006A67))
        ) {
            Text(
                text = "이전",
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
private fun SignUpPasswordScreenPreview() {
    SignUpPasswordScreen()
}