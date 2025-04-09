package com.example.genericapi.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.genericapi.ui.theme.Typography
import com.example.genericapi.ui.viewmodels.MainViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "API Data",
            style = Typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )
        
        when (val state = uiState) {
            is MainViewModel.UiState.Empty -> {
                Text(
                    text = "No data loaded",
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                )
            }
            is MainViewModel.UiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterHorizontally)
                )
            }
            is MainViewModel.UiState.Success -> {
                LazyColumn(modifier = Modifier.weight(1f)) {
                    // Parse and display JSON data here
                    item {
                        Text(
                            text = state.data,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
            is MainViewModel.UiState.Error -> {
                Text(
                    text = state.message,
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                )
            }
        }
        
        Button(
            onClick = { viewModel.fetchData("https://api.example.com/data") },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Refresh Data")
        }
    }
}
