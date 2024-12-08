package com.challenge.internshipchallenge.screen.signup

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun SignUpImageScreen(
    navigateToName: () -> Unit = {},
    navigateToPassword: () -> Unit = {}
) {
    val selectedImage = remember {
        mutableStateOf<Uri?>(null)
    }
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            if (it != null) selectedImage.value = it
        }
    )

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
            text = "이미지를 입로드하세요",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 20.sp
            )
        )

        Box(
            modifier = Modifier
                .padding(top = 40.dp)
                .clip(CircleShape)
                .size(180.dp)
                .background(Color.LightGray)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape),
                model = selectedImage.value,
                contentDescription = "selected image",
                contentScale = ContentScale.Crop
            )
        }

        Button(
            onClick = {
                photoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            },
            modifier = Modifier.padding(top = 28.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006A67))
        ) {
            Text(text = "사진 선택")
        }

        if (selectedImage.value != null) {
            Text(
                text = "초기화",
                modifier = Modifier.clickable {
                    selectedImage.value = null
                },
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navigateToPassword()
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006A67))
        ) {
            Text(text = "다음")
        }

        OutlinedButton(
            onClick = navigateToName,
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
private fun SignUpImageScreenPreview() {
    SignUpImageScreen()
}