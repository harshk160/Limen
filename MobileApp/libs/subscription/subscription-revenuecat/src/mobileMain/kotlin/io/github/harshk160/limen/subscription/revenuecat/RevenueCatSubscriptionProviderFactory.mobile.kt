package io.github.harshk160.limen.subscription.revenuecat

import io.github.harshk160.limen.subscription.api.SubscriptionProvider
import io.github.harshk160.limen.subscription.api.SubscriptionProviderFactory
import io.github.harshk160.limen.subscription.api.SubscriptionProviderUi

internal actual val subscriptionProviderFactory: SubscriptionProviderFactory
    get() =
        object : SubscriptionProviderFactory {
            override fun createProvider(): SubscriptionProvider = RevenueCatSubscriptionProvider()

            override fun createProviderUi(): SubscriptionProviderUi = RevenueCatSubscriptionProviderUi()
        }
