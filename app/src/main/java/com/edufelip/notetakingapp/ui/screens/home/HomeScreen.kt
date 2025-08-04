package com.edufelip.notetakingapp.ui.screens.home

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.edufelip.notetakingapp.ui.screens.emptyNotes.EmptyNotesScreen
import com.edufelip.notetakingapp.ui.theme.NoteTakingAppTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    initialDrawerState: DrawerValue = DrawerValue.Closed
) {
    val drawerState = rememberDrawerState(initialDrawerState)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent()
        }
    ) {
        EmptyNotesScreen(
            openDrawer = {
                scope.launch {
                    drawerState.open()
                }
            },
            onClickCreateNote = {
                // Navigate to create note
            },
            onClickImportNotes = {
                // Import Notes
            }
        )
    }
}

@Preview
@Composable
fun HomeScreenOpenPreview() {
    NoteTakingAppTheme {
        HomeScreen(DrawerValue.Open)
    }
}

@Preview
@Composable
fun HomeScreenClosedPreview() {
    NoteTakingAppTheme {
        HomeScreen(DrawerValue.Closed)
    }
}