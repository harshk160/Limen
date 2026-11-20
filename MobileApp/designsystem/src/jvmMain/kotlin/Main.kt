import androidx.compose.ui.window.singleWindowApplication
import io.github.harshk160.limen.designsystem.AllComponentsGallery

// Note: First time run can take a while because of downloading Jetbrains JDK
fun main() {
    singleWindowApplication(title = "All Components Gallery", alwaysOnTop = true) {
        AllComponentsGallery()
    }
}
