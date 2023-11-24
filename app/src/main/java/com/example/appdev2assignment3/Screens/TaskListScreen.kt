package com.example.assignment2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appdev2assignment3.LocalNavController
import com.example.appdev2assignment3.Screens.SingleViewScreen
import com.example.appdev2assignment3.Task
import com.example.appdev2assignment3.ViewModels.ToDoViewModel
import java.text.SimpleDateFormat
import java.util.Locale


/**
 * Composable function to display a single task item.
 *
 * @param task The task to be displayed.
 */
@Composable
fun TaskItem(task: Task) {
    // Formats the due date to a specific format (dd MMM)
    val formattedDueDate = SimpleDateFormat("dd MMM", Locale.getDefault()).format(task.dueDate)
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Row composable with max width and padding
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Checkbox to mark task as completed
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = { task.toggleCompleted() }
            )

            // Spacer to add some space between checkbox and task details


            // Column composable for task details
            Column(modifier = Modifier.padding(end = 100.dp)) {
                // Display task name in bold
                Text(text = task.name, fontWeight = FontWeight.Bold)
                // Display formatted due date
                Text(text = formattedDueDate)
            }
            AsyncImage(
                model = task.imageLink,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)

            )
        }
    }
}

/**
 * Composable function to display a list of tasks.
 *
 * @param tasks The list of tasks to be displayed.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskList(tasks: List<Task>) {
    val navController = LocalNavController.current
    // RememberLazyListState to manage the scroll position
    val tasksState = rememberLazyListState()


    // LazyColumn composable to display a scrolling list
    LazyColumn(
        modifier = Modifier
            .height(250.dp)
            .width(350.dp),
        state = tasksState
    ) {
        items(tasks) { task ->

            // Card composable to wrap each task item
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp), onClick = {
                    val index = tasks.indexOf(task)
                    navController.navigate("SingleView/$index")
                }
            ) {
                // TaskItem composable to display task details
                TaskItem(task)

            }
        }
    }
}

/**
 * Composable function to display a screen with a list of tasks.
 *
 * @param viewModel The ViewModel containing the list of tasks.
 */
@Composable
fun TaskListScreen(viewModel: ToDoViewModel) {
    // Get the list of tasks from the ViewModel
    val tasks = viewModel.getTasks()

    // Display the list of tasks using TaskList composable
    TaskList(tasks)
}