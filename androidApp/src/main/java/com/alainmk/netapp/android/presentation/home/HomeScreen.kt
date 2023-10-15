package com.alainmk.netapp.android.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: AndroidHomeViewModel = getViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Scaffold { padding ->

        if (!state.isLoading) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                items(state.users) {
                    Text(text = it.username)
                }
            }
        } else {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(40.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    trackColor = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}