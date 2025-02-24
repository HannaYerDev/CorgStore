package com.aermakova.corgstore.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aermakova.corgstore.data.local.UserSettingsRepo
import com.aermakova.corgstore.domain.model.UserMode
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    userSettings: UserSettingsRepo
) : ViewModel() {

    var userMode by mutableStateOf(UserMode.UNAUTHORISED)
        private set

    init {
        userMode = userSettings.getUserMode()
    }
}
