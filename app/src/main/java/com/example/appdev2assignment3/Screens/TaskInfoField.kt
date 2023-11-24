package com.example.assignment2.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.appdev2assignment3.Task
import com.example.appdev2assignment3.ViewModels.ToDoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskInfoField(viewModel: ToDoViewModel) {
    // Display a text label "Add Task:"
    Text(text = "Add Task:",
        modifier = Modifier.padding(0.5.dp))

    // Define two mutable state variables for text input
    var taskName by remember { mutableStateOf("") }
    var taskDueDays by remember { mutableStateOf("") }
    var taskPic by remember { mutableStateOf("")}

    // First TextField for entering task name
    TextField(
        value = taskName,
        onValueChange = { taskName = it },
        label = { Text("Task") },
        shape = RoundedCornerShape(8.dp),
        maxLines = 1,
        modifier = Modifier.padding(15.dp)
    )

    // Second TextField for entering days task is due in
    TextField(
        value = taskDueDays,
        label = { Text("Days task is due in") },
        onValueChange = { taskDueDays = it },
        maxLines = 1,
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.padding(15.dp)
    )
    // Third TextField for entering the url of a image for the task
    TextField(
        value = taskPic,
        onValueChange = { taskPic = it },
        label = { Text("Task Image") },
        shape = RoundedCornerShape(8.dp),
        maxLines = 1,
        modifier = Modifier.padding(15.dp)
    )

    // Button for adding a new task
    Button(
        onClick = {
            // Convert the input days to an integer and add to current date
            val dueDate = viewModel.addDaysToCurrentDate(taskDueDays.toInt())
            val newTask :Task = if(taskPic.isNotBlank()){
                // Create a new Task with provided name, due date and taskPic url
                Task(taskName, dueDate,taskPic)
            } else{
                // Create a new Task with provided name and due date
                Task(taskName, dueDate)
            }

            // Add the new task to the ViewModel
            viewModel.addTask(newTask)

            // Clear input fields after adding the task
            taskName = ""
            taskDueDays = ""
            taskPic = ""
        },
        modifier = Modifier.padding(15.dp),
        // Enable the button only if both fields are not blank
        enabled = taskName.isNotBlank() && taskDueDays.isNotBlank()
    ) {
        // Display text on the button
        Text("Add Task")
    }
}