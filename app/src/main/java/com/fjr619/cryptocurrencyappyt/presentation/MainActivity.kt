package com.fjr619.cryptocurrencyappyt.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fjr619.cryptocurrencyappyt.Screen
import com.fjr619.cryptocurrencyappyt.common.Constants
import com.fjr619.cryptocurrencyappyt.presentation.coin.detail.CoinDetailScreen
import com.fjr619.cryptocurrencyappyt.presentation.coin.list.CoinListScreen
import com.fjr619.cryptocurrencyappyt.presentation.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Navigation with Compose
 * https://developer.android.com/jetpack/compose/navigation
 * https://www.youtube.com/watch?v=OgYfQNbl0ts
 * https://stackoverflow.com/a/65619560
 */

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }

                        composable(
                            route = Screen.CoinDetailScreen.route,

                            //optional to set type, default is String
                            arguments = listOf(
                                navArgument(Constants.PARAM_COIN_ID) {
                                    type = NavType.StringType
                                },
                                navArgument("coinFromList") {
                                    nullable = true
                                },
                                navArgument("test2") {
                                    nullable = true
                                }
                            )
                        ) {
                            //ngetes dengan manggunakan backstackentry, ketika list ada kirim
                            // test, di detail bisa terima hasil dari test
                            // val test = navController.previousBackStackEntry?.savedStateHandle
                            //     ?.get<String>("test")
                            // Log.e("TAG","data test $test")

                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}