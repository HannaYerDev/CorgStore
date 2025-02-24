package com.aermakova.corgstore.ui.boarding

sealed interface BoardingAction {
    data object StartAsGuest : BoardingAction
}