package io.github.harshk160.limen.presentation.components.ads

interface IosAdsDisplayer {

    fun provideInterstitialAdDisplayer(adLoader: FullScreenAdLoader): FullScreenAdDisplayer
    fun provideRewardedAdDisplayer(
        adLoader: FullScreenAdLoader,
        onRewarded: (AdsRewardItem) -> Unit,
    ): FullScreenAdDisplayer
}
