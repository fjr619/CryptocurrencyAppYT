package com.fjr619.cryptocurrencyappyt

import com.fjr619.cryptocurrencyappyt.common.Constants

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen/" +
        "{${Constants.PARAM_COIN_ID}}?coinFromList={coinFromList}&test2={test2}"){

        fun param(coinId: String, coinFromList: String = "", test2: String = ""): String {
            return route
                .replace("{${Constants.PARAM_COIN_ID}}", coinId)
                // .replace("{coinFromList}", coinFromList)
                .replace("{test2}", test2)
        }
    }
}