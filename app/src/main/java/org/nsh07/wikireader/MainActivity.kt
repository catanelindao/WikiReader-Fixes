package org.nsh07.wikireader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import org.nsh07.wikireader.ui.theme.WikiReaderTheme
import org.nsh07.wikireader.ui.viewModel.UiViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: UiViewModel = viewModel(factory = UiViewModel.Factory)
            viewModel.loadPreferences()

            val preferencesState by viewModel.preferencesState.collectAsState()

            val darkTheme = when (preferencesState.theme) {
                "dark" -> true
                "light" -> false
                else -> isSystemInDarkTheme()
            }

            WikiReaderTheme(darkTheme = darkTheme) {
                AppScreen(
                    viewModel = viewModel,
                    preferencesState = preferencesState,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
