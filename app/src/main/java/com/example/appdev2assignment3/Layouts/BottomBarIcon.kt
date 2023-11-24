package com.example.appdev2assignment3.Layouts

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appdev2assignment3.LocalNavController
/**
 * Composable function for displaying the bottom navigation bar with icons.
 */
@Composable
fun BottomBarIcon() {
    val navController = LocalNavController.current
    BottomAppBar(
        actions = {

            Spacer(modifier = Modifier.width(40.dp))

            IconButton(onClick = { navController.navigate("Routes.Main.route")}) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Go Home"
                )
            }

            Spacer(modifier = Modifier.width(40.dp))

            IconButton(onClick = {navController.navigate("SingleView/NoTask") }) {
                Icon(Icons.Filled.Info, contentDescription = "Go to Single View")

            }

            Spacer(modifier = Modifier.width(40.dp))

            IconButton(onClick = {
                navController.navigate("Routes.ListView.route")}) {
                Icon(Icons.Filled.List, contentDescription = "Go to List View")
            }

            Spacer(modifier = Modifier.width(40.dp))

            IconButton(onClick = {
                navController.navigate("Routes.Contact.route")}) {
                Icon(Icons.Filled.Phone, contentDescription = "Go to Contact Us")
            }
        })
}