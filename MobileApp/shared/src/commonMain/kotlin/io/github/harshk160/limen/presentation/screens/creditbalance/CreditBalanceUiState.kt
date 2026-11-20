package io.github.harshk160.limen.presentation.screens.creditbalance

import io.github.harshk160.limen.domain.model.credit.CreditTransaction
import io.github.harshk160.limen.domain.model.credit.RecurringCredit

data class CreditBalanceUiState(
    val creditBalance: Int = 0,
    val isPremiumUser: Boolean = false,
    val isPremiumRequired: Boolean = false,
    val isMoreCreditRequired: Boolean = false,
    val lastTransactions: List<CreditTransaction> = emptyList(),
    val recurringCredits: List<RecurringCredit> = emptyList(),
)

sealed interface CreditBalanceUiEvent {
    data object UpgradeToPremium : CreditBalanceUiEvent
    data object BuyCreditPack : CreditBalanceUiEvent
}
