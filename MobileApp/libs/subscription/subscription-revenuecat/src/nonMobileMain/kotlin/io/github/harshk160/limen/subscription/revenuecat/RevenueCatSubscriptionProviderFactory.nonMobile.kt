package io.github.harshk160.limen.subscription.revenuecat

import io.github.harshk160.limen.subscription.api.NoOpSubscriptionProvider
import io.github.harshk160.limen.subscription.api.NoOpSubscriptionProviderUi
import io.github.harshk160.limen.subscription.api.SubscriptionProvider
import io.github.harshk160.limen.subscription.api.SubscriptionProviderFactory
import io.github.harshk160.limen.subscription.api.SubscriptionProviderUi

internal actual val subscriptionProviderFactory: SubscriptionProviderFactory
    get() =
        object : SubscriptionProviderFactory {
            override fun createProvider(): SubscriptionProvider = NoOpSubscriptionProvider

            override fun createProviderUi(): SubscriptionProviderUi = NoOpSubscriptionProviderUi
        }
