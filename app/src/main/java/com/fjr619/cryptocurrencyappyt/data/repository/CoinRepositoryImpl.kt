package com.fjr619.cryptocurrencyappyt.data.repository

import com.fjr619.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.fjr619.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.fjr619.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.fjr619.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}