package com.example.appdev2assignment3.Layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.appdev2assignment3.LocalNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(
    content: @Composable () -> Unit
) {

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("ToDoS")}) },
        bottomBar = { BottomAppBar { BottomBarIcon() } }
    ) {
        Column(modifier = Modifier.padding(it).fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            content()
        }
    }
}