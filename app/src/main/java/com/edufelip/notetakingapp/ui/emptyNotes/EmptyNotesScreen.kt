package com.edufelip.notetakingapp.ui.emptyNotes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edufelip.notetakingapp.R
import com.edufelip.notetakingapp.ui.theme.ButtonText
import com.edufelip.notetakingapp.ui.theme.GrayText
import com.edufelip.notetakingapp.ui.theme.ImportNotes
import com.edufelip.notetakingapp.ui.theme.NoteTakingAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmptyNotesScreen(
    onCreateNote: () -> Unit,
    onImportNotes: () -> Unit,
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "All Notes",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }, navigationIcon = {
                    IconButton(onClick = {
                        openDrawer()
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                }, actions = {
                    IconButton(onClick = { /* TODO: Search */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }, containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Image(
                    painter = painterResource(id = R.drawable.placeholder_notes_image),
                    contentDescription = "Illustration",
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth(0.7f)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Create Your First Note",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Add a note about anything (your thoughts on climate change, or your history essay) and share it with the world.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = GrayText,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )

                Spacer(modifier = Modifier.height(40.dp))

                Button(
                    onClick = onCreateNote,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(56.dp)
                ) {
                    Text(
                        text = "Create A Note", style = MaterialTheme.typography.titleMedium.copy(
                            color = ButtonText, fontWeight = FontWeight.SemiBold
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextButton(
                    onClick = onImportNotes, modifier = Modifier.fillMaxWidth(0.85f)
                ) {
                    Text(
                        text = "Import Notes", style = MaterialTheme.typography.bodyMedium.copy(
                            color = ImportNotes, fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 360, heightDp = 800)
fun PreviewEmptyNotesScreen() {
    NoteTakingAppTheme {
        EmptyNotesScreen(
            onCreateNote = {},
            onImportNotes = {},
            openDrawer = {},
        )
    }
}
