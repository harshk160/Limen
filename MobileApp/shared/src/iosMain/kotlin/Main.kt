import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import io.github.harshk160.limen.root.App
import io.github.harshk160.limen.util.LocalNativeViewFactory
import io.github.harshk160.limen.util.NativeViewFactory
import io.github.harshk160.limen.util.SwiftLibDependencyFactory
import io.github.harshk160.limen.util.swiftLibDependenciesModule
import org.koin.core.KoinApplication
import platform.UIKit.UIViewController

fun MainViewController(nativeViewFactory: NativeViewFactory): UIViewController = ComposeUIViewController {
    CompositionLocalProvider(LocalNativeViewFactory provides nativeViewFactory) {
        App()
    }
}

// This is called on application started on Swift side
fun KoinApplication.provideSwiftLibDependencyFactory(factory: SwiftLibDependencyFactory) = run { modules(swiftLibDependenciesModule(factory)) }
