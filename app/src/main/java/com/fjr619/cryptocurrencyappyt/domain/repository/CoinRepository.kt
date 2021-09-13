package com.fjr619.cryptocurrencyappyt.domain.repository

import com.fjr619.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.fjr619.cryptocurrencyappyt.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}