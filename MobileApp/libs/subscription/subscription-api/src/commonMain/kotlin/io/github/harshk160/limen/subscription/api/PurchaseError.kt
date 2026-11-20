package io.github.harshk160.limen.subscription.api

data class PurchaseError(
    val message: String,
    val code: String? = null,
)
