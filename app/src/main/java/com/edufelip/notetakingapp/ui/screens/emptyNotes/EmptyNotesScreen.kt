package com.edufelip.notetakingapp.ui.screens.emptyNotes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edufelip.notetakingapp.R
import com.edufelip.notetakingapp.ui.theme.GrayText
import com.edufelip.notetakingapp.ui.theme.NoteTakingAppTheme
import com.edufelip.notetakingapp.ui.theme.PrimaryRed

@Composable
fun EmptyNotesScreen(
    openDrawer: () -> Unit = {},
    onClickCreateNote: () -> Unit = {},
    onClickImportNotes: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            EmptyNotesScreenTopBar(onMenuClick = openDrawer)
        }
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
                    painter = painterResource(id = R.drawable.empty_notes_screen_cover),
                    contentDescription = "Empty Notes Screen Cover",
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth(0.7f)
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Add a note about anything (your thoughts on climate change, or your history essay) and share it witht the world.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = GrayText,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    onClick = {
                        onClickCreateNote()
                    },
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(56.dp)
                ) {
                    Text(
                        text = "Create A Note",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextButton(
                    onClick = {
                        onClickImportNotes()
                    }
                ) {
                    Text(
                        text = "Import Notes",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = PrimaryRed, fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun EmptyNotesScreenPreview() {
    NoteTakingAppTheme {
        EmptyNotesScreen()
    }
}

