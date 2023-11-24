package com.example.appdev2assignment3.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appdev2assignment3.Layouts.MainLayout
import com.example.appdev2assignment3.LocalNavController
import com.example.appdev2assignment3.Task
import com.example.appdev2assignment3.ViewModels.ToDoViewModel
import com.example.assignment2.screens.TaskInfoField
import com.example.assignment2.screens.TaskItem
import com.example.assignment2.screens.TaskListScreen
import java.text.SimpleDateFormat
import java.util.Locale
/**
 * Composable function for displaying the list view screen.
 *
 * @param viewModel The ViewModel containing the list of tasks.
 */
@Composable
fun ListViewScreen(viewModel: ToDoViewModel) {
    MainLayout {
        // Column composable with vertical scroll and centered horizontal alignment
        Column(
            modifier = Modifier.verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Display the tasks title
            ToDoTitle()

            // Display the list of tasks using TaskListScreen composable
            TaskListWithRemoveScreen(viewModel = viewModel)

        }
    }

}
/**
 * Composable function for displaying a task item with a remove button.
 *
 * @param viewModel The ViewModel containing the list of tasks.
 * @param task The task to be displayed.
 */
@Composable
fun TaskItemWithRemove(viewModel: ToDoViewModel,task: Task) {
    // Formats the due date to a specific format (dd MMM)
    val formattedDueDate = SimpleDateFormat("dd MMM", Locale.getDefault()).format(task.dueDate)

    // Row composable with max width and padding
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Checkbox to mark task as completed
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = { task.toggleCompleted() }
        )

        // Spacer to add some space between checkbox and task details
        Spacer(modifier = Modifier.width(8.dp))

        // Column composable for task details
        Column {
            // Display task name in bold
            Text(text = task.name, fontWeight = FontWeight.Bold)
            // Display formatted due date
            Text(text = formattedDueDate)
        }
        var taskIndex = viewModel.getTasks().indexOf(task)
        IconButton(onClick = { viewModel.deleteTask(taskIndex) }) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Go Home"
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
fun TaskList(viewModel: ToDoViewModel, tasks: List<Task>) {
    val navController = LocalNavController.current
    // RememberLazyListState to manage the scroll position
    val tasksState = rememberLazyListState()


    // LazyColumn composable to display a scrolling list
    LazyColumn(
        modifier = Modifier
            .height(350.dp)
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
                TaskItemWithRemove(viewModel,task)

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
fun TaskListWithRemoveScreen(viewModel: ToDoViewModel) {
    // Get the list of tasks from the ViewModel
    val tasks = viewModel.getTasks()

    // Display the list of tasks using TaskList composable
    TaskList(viewModel,tasks)
}