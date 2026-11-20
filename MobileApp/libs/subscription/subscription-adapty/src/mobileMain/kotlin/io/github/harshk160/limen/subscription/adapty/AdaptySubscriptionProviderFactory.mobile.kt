package io.github.harshk160.limen.subscription.adapty

import io.github.harshk160.limen.subscription.api.SubscriptionProvider
import io.github.harshk160.limen.subscription.api.SubscriptionProviderFactory
import io.github.harshk160.limen.subscription.api.SubscriptionProviderUi

internal actual val subscriptionProviderFactory: SubscriptionProviderFactory
    get() =
        object : SubscriptionProviderFactory {
            override fun createProvider(): SubscriptionProvider = AdaptySubscriptionProvider()

            override fun createProviderUi(): SubscriptionProviderUi = AdaptySubscriptionProviderUi()
        }
