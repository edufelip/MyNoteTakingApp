package com.edufelip.notetakingapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.edufelip.notetakingapp.ui.screens.AppRoutes
import com.edufelip.notetakingapp.ui.screens.home.HomeWithDrawer
import com.edufelip.notetakingapp.ui.screens.notedetail.NoteDetailScreen
import com.edufelip.notetakingapp.ui.theme.NoteTakingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteTakingAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val backStack = remember { mutableStateListOf<Any>(AppRoutes.Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            entryProviderFactory(
                key = key,
                drawerState = drawerState,
                backStack = backStack
            )
        },
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { -it })
        },
        popTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { it })
        },
        predictivePopTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { it })
        }
    )
}

fun entryProviderFactory(
    key: Any,
    drawerState: DrawerState,
    backStack: SnapshotStateList<Any>
): NavEntry<Any> {
    return when (key) {
        is AppRoutes.Home -> NavEntry(key) {
            HomeWithDrawer(
                drawerState = drawerState,
                onCreateNoteClicked = {
                    backStack.add(AppRoutes.NoteDetail())
                }
            )
        }

        is AppRoutes.NoteDetail -> NavEntry(key) {
            NoteDetailScreen(noteId = key.id)
        }

        else -> {
            error("Unknown route: $key")
        }
    }
}
