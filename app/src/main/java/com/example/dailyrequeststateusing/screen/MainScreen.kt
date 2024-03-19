package com.example.dailyrequeststateusing.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dailyrequeststateusing.RequestState

@Composable
fun MainScreen() {
    val viewModel: MainViewModel = viewModel()
    val data by viewModel.data.collectAsState(initial = RequestState.Idle)
    data.DisplayResult(
        onLoading = { MainContent() },
        onSuccess = { MainContent(text = data.getSuccessDataOrNull()?.joinToString()) },
        onError = { MainContent(text = data.getErrorMessageOrNull()) }
    )
}

@Composable
fun MainContent(text: String? = null) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if(text != null) {
            Text(
                text = text,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
        } else {
            CircularProgressIndicator()
        }
    }
}