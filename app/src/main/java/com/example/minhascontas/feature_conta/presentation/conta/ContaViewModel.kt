package com.example.minhascontas.feature_conta.presentation.conta

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minhascontas.feature_conta.domain.model.Conta
import com.example.minhascontas.feature_conta.domain.use_case.ContaUseCases
import com.example.minhascontas.feature_conta.domain.util.ContaOrder
import com.example.minhascontas.feature_conta.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContaViewModel @Inject constructor(
    private val contaUseCases: ContaUseCases
) : ViewModel() {

    private val _state = mutableStateOf(ContaState())
    val state: State<ContaState> = _state

    private var recentlyDeletedConta: Conta? = null

    private var getContasJob: Job? = null

    init {
        getContas(ContaOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: ContasEvent) {
        when (event) {
            is ContasEvent.Order -> {
                if (state.value.contaOrder::class == event.contaOrder::class &&
                    state.value.contaOrder.orderType == event.contaOrder.orderType
                ) {
                    return
                }

                getContas(event.contaOrder)
            }
            is ContasEvent.DeleteConta -> {
                viewModelScope.launch {
                    contaUseCases.deleteContaUseCase(event.conta)
                    recentlyDeletedConta = event.conta
                }

            }
            is ContasEvent.RestoreConta -> {
                viewModelScope.launch {
                    contaUseCases.addContaUseCase(recentlyDeletedConta ?: return@launch)
                    recentlyDeletedConta = null
                }
            }
            is ContasEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getContas(contaOrder: ContaOrder) {
        getContasJob?.cancel()
        getContasJob = contaUseCases.getContasUseCase(contaOrder)
            .onEach { contas ->
                _state.value = state.value.copy(
                    contas = contas,
                    contaOrder = contaOrder
                )
            }
            .launchIn(viewModelScope)
    }

}