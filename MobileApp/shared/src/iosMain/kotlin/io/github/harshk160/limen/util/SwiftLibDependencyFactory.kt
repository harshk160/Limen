package io.github.harshk160.limen.util

import io.github.harshk160.limen.data.source.featureflag.FeatureFlagManager
import io.github.harshk160.limen.presentation.components.ads.AdsManager
import io.github.harshk160.limen.presentation.components.ads.IosAdsDisplayer
import io.github.harshk160.limen.util.analytics.Analytics

/**
This factory is used to help to use swift libraries in KMP. Actual implementations are provided in swift.
 */
interface SwiftLibDependencyFactory {
    fun provideFeatureFlagManagerImpl(): FeatureFlagManager
    fun provideFirebaseAnalyticsImpl(): Analytics
    fun provideAdsManagerImpl(): AdsManager
    fun provideIosAdsDisplayer(): IosAdsDisplayer
}
