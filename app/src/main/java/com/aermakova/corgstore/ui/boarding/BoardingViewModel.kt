package com.aermakova.corgstore.ui.boarding

import androidx.lifecycle.ViewModel
import com.aermakova.corgstore.data.local.UserSettingsRepo
import com.aermakova.corgstore.domain.model.UserMode
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BoardingViewModel @Inject constructor(
    private val userSettings: UserSettingsRepo
) : ViewModel() {

    fun onAction(action: BoardingAction) {
        when (action) {
            BoardingAction.StartAsGuest -> saveUserAsGuest()
        }
    }

    private fun saveUserAsGuest() {
        userSettings.saveUsedMode(UserMode.GUEST)
    }
}
