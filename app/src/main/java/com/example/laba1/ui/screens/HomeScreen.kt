package com.example.laba1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laba1.viewmodel.AppViewModel

@Composable
fun HomeScreen(viewModel: AppViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home_main"
    ) {
        composable("home_main") {
            HomeMainSubScreen(
                viewModel = viewModel,
                onNavigateToDetails = {
                    navController.navigate("home_details")
                }
            )
        }

        composable("home_details") {
            val homeClickCount by viewModel.homeClickCount.collectAsState()
            HomeDetailsSubScreen(
                clickCount = homeClickCount,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
private fun HomeMainSubScreen(
    viewModel: AppViewModel,
    onNavigateToDetails: () -> Unit
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val homeClickCount by viewModel.homeClickCount.collectAsState()
        val homeMessage by viewModel.homeMessage.collectAsState()
        Text(
            text = homeMessage,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Натискань: $homeClickCount",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = { viewModel.onHomeButtonClick() }) {
            Text("Кнопка Home")
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedButton(onClick = onNavigateToDetails) {
            Text("Перейти до деталей ➡️")
        }
    }
}

@Composable
private fun HomeDetailsSubScreen(
    clickCount: Int,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Детальний підекран (Лабораторна №2)",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Text(
            text = "Поточна кількість кліків із ViewModel: $clickCount",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Button(
            onClick = onNavigateBack,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
        ) {
            Text("⬅️ Повернутися назад")
        }
    }
}