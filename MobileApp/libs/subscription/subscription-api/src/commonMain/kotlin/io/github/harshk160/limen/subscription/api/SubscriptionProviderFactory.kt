package io.github.harshk160.limen.subscription.api

interface SubscriptionProviderFactory {
    companion object

    fun createProvider(): SubscriptionProvider

    fun createProviderUi(): SubscriptionProviderUi
}
