package com.edufelip.notetakingapp.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edufelip.notetakingapp.R
import com.edufelip.notetakingapp.ui.screens.emptyNotes.EmptyNotesScreen
import com.edufelip.notetakingapp.ui.theme.NoteTakingAppTheme
import kotlinx.coroutines.launch

@Composable
fun HomeWithDrawer(
    onCreateNoteClicked: () -> Unit = {},
    onImportNotesClicked: () -> Unit = {},
    drawerState: DrawerState,
) {
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = stringResource(R.string.my_notes),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp)
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(stringResource(R.string.all_notes)) },
                    selected = true,
                    onClick = {
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
                NavigationDrawerItem(
                    label = { Text(stringResource(R.string.settings)) },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }
        }
    ) {
        EmptyNotesScreen(
            modifier = Modifier,
            onCreateNoteClicked = onCreateNoteClicked,
            onImportNotes = onImportNotesClicked,
            openDrawer = { scope.launch { drawerState.open() } },
        )
    }
}

@Preview
@Composable
fun PreviewHomeWithDrawerOpen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    NoteTakingAppTheme {
       HomeWithDrawer(drawerState = drawerState)
   }
}


@Preview
@Composable
fun PreviewHomeWithDrawerClosed() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    NoteTakingAppTheme {
        HomeWithDrawer(drawerState = drawerState)
    }
}