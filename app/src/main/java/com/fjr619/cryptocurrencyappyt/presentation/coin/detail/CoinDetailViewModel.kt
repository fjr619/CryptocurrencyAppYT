package com.fjr619.cryptocurrencyappyt.presentation.coin.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjr619.cryptocurrencyappyt.common.Constants
import com.fjr619.cryptocurrencyappyt.common.Resource
import com.fjr619.cryptocurrencyappyt.domain.usecase.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                }
                is Resource.Error -> {
                }
                is Resource.Loading -> {
                }
            }
        }.launchIn(viewModelScope)
    }
}