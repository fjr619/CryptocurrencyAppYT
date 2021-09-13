package com.fjr619.cryptocurrencyappyt.presentation.coin.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjr619.cryptocurrencyappyt.common.Resource
import com.fjr619.cryptocurrencyappyt.domain.usecase.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
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