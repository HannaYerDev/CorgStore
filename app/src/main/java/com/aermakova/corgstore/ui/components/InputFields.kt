package com.aermakova.corgstore.ui.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.aermakova.corgstore.ui.theme.AppStrings
import com.aermakova.corgstore.ui.theme.AppTheme

@Composable
fun EmailInputField(
    modifier: Modifier = Modifier,
    onEmailChanged: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    var email by remember { mutableStateOf("") }
    TextField(
        modifier = modifier,
        value = email,
        onValueChange = {
            email = it
            onEmailChanged(it)
        },
        label = { Text(AppStrings.email) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        colors = inputFieldsDefaultColors(),
    )
}

@Composable
fun PasswordInputField(
    modifier: Modifier = Modifier,
    onPasswordChanged: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current

    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        modifier = modifier,
        value = password,
        onValueChange = {
            password = it
            onPasswordChanged(it)
        },
        label = { Text(AppStrings.password) },
        trailingIcon = {
            val image = if (passwordVisible)

                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, description)
            }
        },
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() }
        ),
        colors = inputFieldsDefaultColors()
    )
}

@Composable
private fun inputFieldsDefaultColors() = TextFieldDefaults.colors(
    focusedTextColor = AppTheme.colors.black,
    unfocusedTextColor = AppTheme.colors.black,

    focusedContainerColor = AppTheme.colors.filterColor,
    unfocusedContainerColor = AppTheme.colors.white,

    cursorColor = AppTheme.colors.black,

    focusedIndicatorColor = AppTheme.colors.counterColor,
    unfocusedIndicatorColor = AppTheme.colors.counterColor,

    focusedLabelColor = AppTheme.colors.light,
    unfocusedLabelColor = AppTheme.colors.light
)