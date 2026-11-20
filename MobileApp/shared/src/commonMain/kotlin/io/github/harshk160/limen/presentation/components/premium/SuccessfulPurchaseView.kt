package io.github.harshk160.limen.presentation.components.premium

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import io.github.harshk160.limen.designsystem.components.premium.PremiumFeatureUiState
import io.github.harshk160.limen.designsystem.components.premium.SuccessfulPurchaseContent
import io.github.harshk160.limen.util.Constants.subscriptionUrl
import io.github.harshk160.limen.util.inappreview.rememberInAppReviewTrigger
import io.github.harshk160.limen.util.logging.AppLogger
import io.github.harshk160.limen.util.logging.logSuccessfulPurchase

@Composable
fun SuccessfulPurchaseView(
    features: List<PremiumFeatureUiState> = emptyList(),
    expirationDate: String? = null,
    isLifetime: Boolean = false,
    isRecurring: Boolean = true,
    modifier: Modifier = Modifier,
    onContinue: () -> Unit = {},
) {
    val inAppReviewTrigger = rememberInAppReviewTrigger()
    LaunchedEffect(Unit) {
        AppLogger.logSuccessfulPurchase()
        inAppReviewTrigger.triggerAfterSuccessfulPurchase()
    }

    SuccessfulPurchaseContent(
        subscriptionUrl = subscriptionUrl,
        features = features,
        expirationDate = expirationDate,
        isLifetime = isLifetime,
        isRecurring = isRecurring,
        modifier = modifier,
        onContinue = onContinue,
    )
}
