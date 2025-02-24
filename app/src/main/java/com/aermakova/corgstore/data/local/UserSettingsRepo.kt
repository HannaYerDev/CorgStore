package com.aermakova.corgstore.data.local

import com.aermakova.corgstore.domain.model.UserMode

interface UserSettingsRepo {
    fun saveUsedMode(mode: UserMode)
    fun getUserMode(): UserMode
}