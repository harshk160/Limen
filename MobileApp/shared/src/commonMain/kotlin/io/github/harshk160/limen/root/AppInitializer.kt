package io.github.harshk160.limen.root

import io.github.harshk160.limen.util.isDebug
import io.github.harshk160.limen.util.logging.AppLogger
import io.github.harshk160.limen.util.onApplicationStartPlatformSpecific
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

/**
 * App bootstrap: starts Koin with all modules and runs one-time startup side effects
 * (logging and platform setup). Each platform's entry point calls [initialize] once,
 * passing platform-specific Koin setup via [onKoinStart].
 */
object AppInitializer {

    fun initialize(onKoinStart: KoinApplication.() -> Unit) {
        startKoin {
            onKoinStart()
            modules(appModules)
            onApplicationStart()
        }
    }

    private fun KoinApplication.onApplicationStart() {
        onApplicationStartPlatformSpecific()
        // Initialize logging
        AppLogger.initialize(isDebug = isDebug)
    }
}

// Koin module definitions (appModules, dataModule, presentationModule, …) live in Di.kt.
