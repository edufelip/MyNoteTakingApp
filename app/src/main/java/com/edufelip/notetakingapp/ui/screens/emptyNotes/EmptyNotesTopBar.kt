package com.edufelip.notetakingapp.ui.screens.emptyNotes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.edufelip.notetakingapp.ui.theme.NoteTakingAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmptyNotesScreenTopBar(
    onMenuClick: () -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "All Notes",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    onMenuClick()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Search"
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    onSearchClick()
                }
            ) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors().copy(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}

@Composable
@Preview
fun EmptyScreenTopBarPreview() {
    NoteTakingAppTheme {
        EmptyNotesScreenTopBar()
    }
}