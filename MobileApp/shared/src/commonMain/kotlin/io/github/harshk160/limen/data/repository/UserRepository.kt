package io.github.harshk160.limen.data.repository

import io.github.harshk160.limen.data.BackgroundExecutor
import io.github.harshk160.limen.data.source.preferences.UserPreferences
import io.github.harshk160.limen.domain.exceptions.UnAuthorizedException
import io.github.harshk160.limen.domain.model.User
import io.github.harshk160.limen.util.ApplicationScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Owns the authenticated user session. Emits `Result.failure(UnAuthorizedException)` when signed out.
 *
 * Koko's Firebase/KMPAuth anonymous sign-in is disabled; Limen's email/password + JWT auth plugs in here.
 */
class UserRepository(
    @Suppress("unused") private val subscriptionRepository: SubscriptionRepository,
    @Suppress("unused") private val userPreferences: UserPreferences,
    private val backgroundExecutor: BackgroundExecutor = BackgroundExecutor.IO,
    private val applicationScope: ApplicationScope,
) {

    // TODO(T2.4/T4.1): replace with Limen session/JWT auth
    private val _currentUser = MutableStateFlow<Result<User>>(Result.failure(UnAuthorizedException()))

    val currentUser: SharedFlow<Result<User>> = _currentUser.asStateFlow()

    fun signInAnonymouslyIfNecessary(): Job = applicationScope.launch {
        // Intentionally disabled: Limen does not use Firebase anonymous sign-in.
    }

    fun onSuccessfulOauthSign() {
        // TODO(T2.4/T4.1): replace with Limen session/JWT auth
    }

    suspend fun continueAsGuest(): Result<Unit> = backgroundExecutor.execute {
        // TODO(T2.4/T4.1): replace with Limen session/JWT auth
        Result.failure(UnAuthorizedException())
    }

    suspend fun logOut(): Result<Unit> = backgroundExecutor.execute {
        // TODO(T2.4/T4.1): replace with Limen session/JWT auth
        _currentUser.value = Result.failure(UnAuthorizedException())
        Result.success(Unit)
    }

    suspend fun deleteAccount(): Result<Unit> = backgroundExecutor.execute {
        // TODO(T2.4/T4.1): replace with Limen session/JWT auth
        _currentUser.value = Result.failure(UnAuthorizedException())
        Result.success(Unit)
    }
}
