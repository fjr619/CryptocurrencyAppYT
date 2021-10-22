package com.fjr619.cryptocurrencyappyt.presentation.coin.list

import com.fjr619.cryptocurrencyappyt.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)