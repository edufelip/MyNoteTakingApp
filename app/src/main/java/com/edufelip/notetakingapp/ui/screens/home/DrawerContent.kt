package com.edufelip.notetakingapp.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edufelip.notetakingapp.ui.theme.NoteTakingAppTheme

@Composable
fun DrawerContent() {
    ModalDrawerSheet {
        Text(
            text =  "My Notes",
            modifier = Modifier.padding(16.dp)
        )
        HorizontalDivider()
        NavigationDrawerItem(
            label = { Text(text = "Create Note") },
            selected = true,
            onClick = {},
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }
}

@Composable
@Preview
fun DrawerContentPreview() {
    NoteTakingAppTheme {
        DrawerContent()
    }
}