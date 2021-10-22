package com.fjr619.cryptocurrencyappyt.presentation.coin.detail

import com.fjr619.cryptocurrencyappyt.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)