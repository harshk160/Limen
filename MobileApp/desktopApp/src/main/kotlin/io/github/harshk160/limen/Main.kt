package io.github.harshk160.limen

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.harshk160.limen.root.App
import io.github.harshk160.limen.root.AppInitializer

fun main() {
    System.setProperty("java.util.logging.SimpleFormatter.format", $$"%5$s%6$s%n")

    application {
        AppInitializer.initialize {}
        Window(
            onCloseRequest = ::exitApplication,
            title = "Limen",
        ) {
            App()
        }
    }
}
