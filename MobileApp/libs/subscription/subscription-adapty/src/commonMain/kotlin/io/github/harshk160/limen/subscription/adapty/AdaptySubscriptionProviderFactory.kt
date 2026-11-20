package io.github.harshk160.limen.subscription.adapty

import io.github.harshk160.limen.subscription.api.SubscriptionProviderFactory

val SubscriptionProviderFactory.Companion.Adapty: SubscriptionProviderFactory
    get() = subscriptionProviderFactory

internal expect val subscriptionProviderFactory: SubscriptionProviderFactory
