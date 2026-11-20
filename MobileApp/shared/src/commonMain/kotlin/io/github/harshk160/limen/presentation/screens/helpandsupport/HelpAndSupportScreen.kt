package io.github.harshk160.limen.presentation.screens.helpandsupport

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import io.github.harshk160.limen.designsystem.components.ScreenWithToolbar
import io.github.harshk160.limen.designsystem.components.SettingItemListContainer
import io.github.harshk160.limen.designsystem.components.SettingsItemUiState
import io.github.harshk160.limen.designsystem.generated.resources.UiRes
import io.github.harshk160.limen.designsystem.generated.resources.ic_back
import io.github.harshk160.limen.designsystem.generated.resources.privacy_policy
import io.github.harshk160.limen.designsystem.generated.resources.terms_conditions
import io.github.harshk160.limen.designsystem.theme.AppTheme
import io.github.harshk160.limen.generated.resources.Res
import io.github.harshk160.limen.generated.resources.help_and_support
import io.github.harshk160.limen.generated.resources.item_contact_support
import io.github.harshk160.limen.root.AppConfiguration
import io.github.harshk160.limen.util.AppUtil
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun HelpAndSupportScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
) {
    val itemList = listOf(
        SettingsItemUiState(textRes = Res.string.item_contact_support),
        SettingsItemUiState(textRes = UiRes.string.privacy_policy),
        SettingsItemUiState(textRes = UiRes.string.terms_conditions),
    )
    val localUriHandler = LocalUriHandler.current
    val appUtil = koinInject<AppUtil>()
    ScreenWithToolbar(
        modifier = modifier.fillMaxSize().background(AppTheme.colors.background),
        title = stringResource(Res.string.help_and_support),
        includeBottomInsets = true,
        isScrollableContent = true,
        onNavigationIconClick = onNavigateBack,
        navigationIcon = UiRes.drawable.ic_back,
    ) {
        SettingItemListContainer(
            itemList = itemList,
            itemTextStyle = AppTheme.typography.h5.copy(fontWeight = FontWeight.SemiBold),
            onClick = {
                when (it.textRes) {
                    Res.string.item_contact_support -> {
                        appUtil.openFeedbackMail()
                    }

                    UiRes.string.privacy_policy -> {
                        localUriHandler.openUri(AppConfiguration.URL_PRIVACY_POLICY)
                    }

                    UiRes.string.terms_conditions -> {
                        localUriHandler.openUri(AppConfiguration.URL_TERMS_CONDITIONS)
                    }
                }
            },
        )
    }
}

@Preview
@Composable
private fun HelpAndSupportScreenPreview() {
    AppTheme {
        HelpAndSupportScreen(onNavigateBack = {})
    }
}
