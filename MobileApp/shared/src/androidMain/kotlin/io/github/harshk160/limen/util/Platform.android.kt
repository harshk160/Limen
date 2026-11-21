package io.github.harshk160.limen.util

import com.google.firebase.Firebase
import com.google.firebase.analytics.analytics
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.mmk.kmpnotifier.KMPNotifier
import com.mmk.kmpnotifier.notification.configuration.NotificationPlatformConfiguration
import com.mmk.kmpnotifier.push.firebase.FirebasePush
import io.github.harshk160.limen.common.BuildConfig
import io.github.harshk160.limen.data.source.featureflag.FeatureFlagManager
import io.github.harshk160.limen.data.source.featureflag.FeatureFlagManagerImpl
import io.github.harshk160.limen.data.source.local.DatabaseProvider
import io.github.harshk160.limen.data.source.local.DatabaseProviderImpl
import io.github.harshk160.limen.data.source.local.databaseModule
import io.github.harshk160.limen.data.source.preferences.PreferencesDataStoreProvider
import io.github.harshk160.limen.data.source.preferences.PreferencesDataStoreProviderImpl
import io.github.harshk160.limen.presentation.components.ads.AdsManager
import io.github.harshk160.limen.presentation.components.ads.AdsManagerImpl
import io.github.harshk160.limen.shared.R
import io.github.harshk160.limen.util.analytics.Analytics
import io.github.harshk160.limen.util.analytics.FirebaseAnalyticsImpl
import io.github.harshk160.limen.util.file.FileManager
import io.github.harshk160.limen.util.file.FileManagerImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual val platformModule: Module = module {

    includes(databaseModule)
    singleOf(::DatabaseProviderImpl) bind DatabaseProvider::class
    singleOf(::PreferencesDataStoreProviderImpl) bind PreferencesDataStoreProvider::class
    factory<FileManager> { FileManagerImpl() }
    factoryOf(::AppUtilImpl) bind AppUtil::class
    single<FeatureFlagManagerImpl> {
        val remoteConfig = Firebase.remoteConfig.apply {
            setConfigSettingsAsync(
                remoteConfigSettings {
                    // set minimumFetchIntervalInSeconds to 0 to get fresh updates in debug mode for testing
                    if (BuildConfig.DEBUG) minimumFetchIntervalInSeconds = 3600
                },
            )
            setDefaultsAsync(FeatureFlagManager.DEFAULT_VALUES)
        }
        FeatureFlagManagerImpl(remoteConfig = remoteConfig)
    } bind FeatureFlagManager::class
    single { FirebaseAnalyticsImpl(firebaseAnalytics = Firebase.analytics) } bind Analytics::class
    singleOf(::AdsManagerImpl) bind AdsManager::class
}

internal actual fun onApplicationStartPlatformSpecific() {
    KMPNotifier.initialize(
        NotificationPlatformConfiguration.Android(
            notificationIconResId = R.drawable.ic_notification,
        ),
        FirebasePush,
    )
}

actual fun getPlatform(): Platform = Platform.Android

internal actual val isAndroid = true
internal actual val isDebug = BuildConfig.DEBUG
actual val defaultAsyncDispatcher: CoroutineDispatcher = Dispatchers.IO
