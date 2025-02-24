package com.aermakova.corgstore.data.repository

import android.content.SharedPreferences
import com.aermakova.corgstore.data.local.UserSettingsRepo
import com.aermakova.corgstore.domain.model.UserMode

class UserSettingsRepository(
    private val preferences: SharedPreferences
) : UserSettingsRepo {

    companion object {
        private const val USER_MODE = "USER_MODE"
    }

    override fun saveUsedMode(mode: UserMode) {
        preferences.edit().putInt(USER_MODE, mode.code).apply()
    }

    override fun getUserMode(): UserMode {
        return when (preferences.getInt(USER_MODE, UserMode.UNAUTHORISED.code)) {
            UserMode.GUEST.code -> UserMode.GUEST
            UserMode.AUTHORIZED.code -> UserMode.AUTHORIZED
            else -> UserMode.UNAUTHORISED
        }
    }
}