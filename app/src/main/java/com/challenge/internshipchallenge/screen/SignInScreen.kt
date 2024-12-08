package com.challenge.internshipchallenge.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignInScreen(
    navigateToProfile: () -> Unit = {},
    navigateToMain: () -> Unit = {}
) {
    val id = remember { mutableStateOf("") }
    val pw = remember { mutableStateOf("") }
    val idError = remember { mutableStateOf(false) }
    val pwError = remember { mutableStateOf(false) }

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
            text = "로그인",
            modifier = Modifier.padding(vertical = 8.dp),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        Text(
            text = "ID와 비밀번호를 입력해\n로그인 하세요.",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 20.sp
            ),
            textAlign = TextAlign.Center
        )

        TextField(
            value = id.value,
            onValueChange = { id.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp),
            label = { Text(text = "ID") },
            placeholder = { Text(text = "ID를 입력해주세요") },
            trailingIcon = {
                IconButton(onClick = { id.value = "" }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "id clear text icon",
                    )
                }
            },
            isError = idError.value,
            supportingText = {
                if (idError.value) Text(text = "비어 있어요")
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0x1A0000FF),
                unfocusedIndicatorColor = Color.Blue,
                focusedIndicatorColor = Color.Blue
            )
        )

        TextField(
            value = pw.value,
            onValueChange = { pw.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            label = { Text(text = "비밀번호") },
            placeholder = { Text(text = "비밀번호를 입력해주세요") },
            trailingIcon = {
                IconButton(onClick = { pw.value = "" }) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "user name clear text icon",
                    )
                }
            },
            isError = pwError.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            supportingText = {
                if (pwError.value) Text(text = "비어 있어요")
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
                idError.value = id.value.isEmpty()
                pwError.value = pw.value.isEmpty()

                if (!idError.value && !pwError.value) {
                    // todo :: fireStore 데이터 확인 로직
                    navigateToMain()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006A67))
        ) {
            Text(text = "로그인")
        }
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    SignInScreen()
}