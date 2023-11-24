package com.example.appdev2assignment3.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appdev2assignment3.Layouts.MainLayout
import com.example.appdev2assignment3.ViewModels.ToDoViewModel

/**
 * Composable function for displaying task details of the last task added.
 *
 * @param viewModel The ViewModel containing the list of tasks.
 */
@Composable
fun SingleViewScreenNoTask(viewModel: ToDoViewModel) {
    val message = "Please add a task first before viewing this page"
    var isCompleted = ""

    MainLayout {
        Column {
            if (viewModel.getTasks().isEmpty()) {
                Text(text = message)
            } else {
                Text(text = "Task name: ${viewModel.getTasks().last().name}")
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Task due date: ${viewModel.getTasks().last().dueDate}")
                Spacer(modifier = Modifier.height(15.dp))
                isCompleted = if(viewModel.getTasks().last().isCompleted){
                    "Yes"
                } else{
                    "No"
                }
                Text(text = "Task is completed: $isCompleted")

            }
        }

    }
}
/**
 * Composable function for displaying details of a specific task.
 *
 * @param viewModel The ViewModel containing the list of tasks.
 * @param index The index of the task to display.
 */
@Composable
fun SingleViewScreen(viewModel: ToDoViewModel,index: Int) {
    var tasks=viewModel.getTasks()
    var targetTask = tasks[index]
    var isCompleted = ""
    if(targetTask.isCompleted){
        isCompleted="Yes"
    }
    else{
        isCompleted="No"
    }
    MainLayout {
        Column{
            Text(text = "Task name: ${targetTask.name}")
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Task due date: ${targetTask.dueDate}")
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Task is completed: $isCompleted")

        }
    }

    }

