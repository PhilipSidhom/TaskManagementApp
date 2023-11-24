package com.example.appdev2assignment3.ViewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.appdev2assignment3.Task
import java.util.Calendar
import java.util.Date

// This is a ViewModel class responsible for managing tasks.
class ToDoViewModel : ViewModel() {

    // A mutable list of tasks using mutableStateListOf.
    private val taskList = mutableStateListOf<Task>()

    // This function retrieves the list of tasks.
    fun getTasks(): List<Task> {
        return taskList
    }

    // This function adds a task to the list.
    fun addTask(task: Task) {
        taskList.add(task)
    }

    fun deleteTask(taskIndex: Int) {
        if (taskIndex in 0 until taskList.size) {
            taskList.removeAt(taskIndex)
        }
    }


    // This function calculates the date after adding a specified number of days to the current date.
    fun addDaysToCurrentDate(daysToAdd: Int): Date {
        // Create a Calendar instance to manipulate dates.
        val calendar = Calendar.getInstance()
        // Add the specified number of days to the current date.
        calendar.add(Calendar.DAY_OF_YEAR, daysToAdd)
        // Return the modified date.
        return calendar.time
    }
}