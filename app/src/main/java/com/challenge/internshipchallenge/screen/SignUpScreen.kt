package com.challenge.internshipchallenge.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.challenge.internshipchallenge.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = viewModel<SignUpViewModel>(),
    navigateToSignIn: () -> Unit = {},
    navigateToMain: () -> Unit = {}
) {
    val context = LocalContext.current

    val id = remember { mutableStateOf("") }
    val userName = remember { mutableStateOf("") }
    val pw = remember { mutableStateOf("") }
    val pwCheck = remember { mutableStateOf("") }
    val idError = remember { mutableStateOf(false) }
    val userNameError = remember { mutableStateOf(false) }
    val pwError = remember { mutableStateOf(false) }
    val pwCheckError = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "back to sign in",
                modifier = Modifier
                    .clickable { navigateToMain() }
                    .padding(vertical = 20.dp, horizontal = 16.dp)
            )

            Text(
                text = "회원가입",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = "app icon",
            modifier = Modifier
                .padding(top = 36.dp)
                .size(50.dp)
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
            text = "지원자의 정보를 입력해\n가입을 진행합니다.",
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
                .padding(top = 28.dp, start = 24.dp, end = 24.dp),
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
            supportingText = {
                if (idError.value) Text(text = "비어 있어요")
            },
            isError = idError.value,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0x1A0000FF),
                unfocusedIndicatorColor = Color.Blue,
                focusedIndicatorColor = Color.Blue
            )
        )

        TextField(
            value = userName.value,
            onValueChange = { userName.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 24.dp, end = 24.dp),
            label = { Text(text = "사용자명") },
            placeholder = { Text(text = "사용자명을 입력해주세요") },
            trailingIcon = {
                IconButton(onClick = { userName.value = "" }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "user name clear text icon",
                    )
                }
            },
            supportingText = {
                if (userNameError.value) Text(text = "비어 있어요")
            },
            isError = userNameError.value,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            singleLine = true,
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
                .padding(top = 8.dp, start = 24.dp, end = 24.dp),
            label = { Text(text = "비밀번호") },
            placeholder = { Text(text = "비밀번호를 입력해주세요") },
            trailingIcon = {
                IconButton(onClick = { pw.value = "" }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "pw clear text icon",
                    )
                }
            },
            supportingText = {
                if (pwError.value) Text(text = "비어 있어요")
            },
            isError = pwError.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next),
            singleLine = true,
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
                .padding(top = 8.dp, start = 24.dp, end = 24.dp),
            label = { Text(text = "비밀번호 확인") },
            placeholder = { Text(text = "비밀번호를 다시 입력해주세요") },
            trailingIcon = {
                IconButton(onClick = { pwCheck.value = "" }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "pw check clear text icon",
                    )
                }
            },
            isError = pwCheckError.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
            supportingText = {
                if (pwCheckError.value) Text(text = "비밀번호가 틀려요")
            },
            singleLine = true,
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
                userNameError.value = userName.value.isEmpty()
                pwError.value = pw.value.isEmpty()
                pwCheckError.value = pwCheck.value != pw.value

                if (!idError.value && !userNameError.value && !pwError.value && !pwCheckError.value) {
                    signUpViewModel.saveUserData(
                        id = id.value,
                        name = userName.value,
                        pw = pw.value
                    )
                    signUpViewModel.signUp(
                        onSuccess = {
                            Toast.makeText(context, "회원가입 성공", Toast.LENGTH_SHORT).show()
                        },
                        onFailure = {
                            Toast.makeText(context, "회원가입 실패", Toast.LENGTH_SHORT).show()
                        }
                    )
                    navigateToSignIn()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 36.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006A67))
        ) {
            Text(text = "완료")
        }
    }
}

@Preview
@Composable
private fun SignUpNameScreenPreview() {
    SignUpScreen()
}