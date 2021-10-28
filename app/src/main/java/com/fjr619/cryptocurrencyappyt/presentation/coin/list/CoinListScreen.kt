package com.fjr619.cryptocurrencyappyt.presentation.coin.list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fjr619.cryptocurrencyappyt.Screen
import com.fjr619.cryptocurrencyappyt.presentation.coin.list.components.CoinListItem
import com.google.gson.Gson


@Composable
fun testRemember() {
    val isOn = remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier
        .background(if (isOn.value) Color.Blue else MaterialTheme.colors.primary)
        .fillMaxSize()
    ) {
        Button(
            modifier = Modifier.padding(64.dp).fillMaxSize(),
            colors = ButtonDefaults.buttonColors(backgroundColor = if (!isOn.value) Color.Blue
            else MaterialTheme.colors.primary),
            onClick = { isOn.value = !isOn.value }) {
            Text(
                text =  if (isOn.value) "on" else "off",
                color = if (isOn.value) Color.Blue else MaterialTheme.colors.primary,
                fontSize = 48.sp
            )
        }
    }
}

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val state = viewModel.state.value

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.coins) { coins ->
                CoinListItem(
                    coin = coins,
                    onItemClick = {
                        val coinToString = Gson().toJson(it)
                        val route = Screen.CoinDetailScreen.param(
                            coinId = coins.id,
                            coinFromList = coinToString
                        )
                        Log.e("TAG", "route $route")

                        navController.navigate(route)
                    }
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}