package org.nsh07.wikireader.ui.viewModel

import androidx.compose.ui.focus.FocusRequester
import org.nsh07.wikireader.data.WikiPhoto
import org.nsh07.wikireader.data.WikiPhotoDesc

data class SearchBarState(
    val query: String = "",
    val isSearchBarExpanded: Boolean = false,
    val history: Set<String> = setOf(),
    val focusRequester: FocusRequester = FocusRequester()
)

data class HomeScreenState(
    val title: String = "",
    val extract: List<String> = emptyList(),
    val photo: WikiPhoto? = null,
    val photoDesc: WikiPhotoDesc? = null,
    val isLoading: Boolean = false
)

data class PreferencesState(
    val theme: String = "auto",
    val fontSize: Int = 16,
    val expandedSections: Boolean = false,
    val dataSaver: Boolean = false
)