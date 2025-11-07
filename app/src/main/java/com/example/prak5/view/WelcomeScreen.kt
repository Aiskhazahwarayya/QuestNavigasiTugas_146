package com.example.cn.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WelcomeScreen(
    onSubmitClick: () -> Unit
) {
    val colorBackground = Color(0xFFE6E6FA)
    val colorPurple700 = Color(0xFF673AB7)
    val colorDeepPurple = Color(0xFF512DA8)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 40.dp)
        ) {
            Text(
                text = "Selamat Datang",
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                color = colorPurple700,
                textAlign = TextAlign.Center
            )
        }
    }
}