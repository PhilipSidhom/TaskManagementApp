package com.example.appdev2assignment3.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appdev2assignment3.Layouts.MainLayout
import com.example.appdev2assignment3.ViewModels.ToDoViewModel
import com.example.assignment2.screens.TaskInfoField
import com.example.assignment2.screens.TaskListScreen


/**
 * Composable function to display the top banner.
 */
@Composable
fun TopBanner() {
    Text(
        text = "ToDoS",
        fontSize = 50.sp,
    )
}

/**
 * Composable function to display the title for tasks.
 */
@Composable
fun ToDoTitle() {
    Text(
        text = "Tasks: ",
        fontSize = 25.sp,
    )
}

/**
 * Composable function to display the full screen layout including the top banner,
 * title, task list, and task info field.
 *
 * @param viewModel The ViewModel containing the list of tasks.
 */
@Composable
fun FullScreen(viewModel: ToDoViewModel){
    MainLayout {
        Column(modifier = Modifier.verticalScroll(state = rememberScrollState()),horizontalAlignment= Alignment.CenterHorizontally ) {
            // Display the top banner
            //TopBanner()

            // Add a spacer for some vertical space
            Spacer(modifier = Modifier.height(20.dp))

            // Display the tasks title
            // ToDoTitle()

            // Display the list of tasks using TaskListScreen composable
            TaskListScreen(viewModel = viewModel)

            // Add another spacer for vertical space
            Spacer(modifier = Modifier.height(20.dp))

            // Display the task info field for adding tasks
            TaskInfoField(viewModel = viewModel)
        }
    }

}